import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.IntStream;

public class 주차요금계산하기 {
    /**
     * TODO
     *  - 입차할 때, 입/주차 기록 map 형태로 저장 < 차량 번호, 시각 >
     *  - 출차할 때, map 에서 차량 번호를 조회
     *  - 있으면, map < 차량 번호, 이용 시간 > 시간 계산 / map < 차량 번호, 주차 요금 > 시간 계산
     *  - 계산 후, map 형태로 저장
     *  - 만약, 해당 차량의 기록이 있다면 추가로 플러스
     * **/

    private static Map<String, Car> carMap = new HashMap<>(); // 차량 번호판으로 구분되는 Car Map

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] solution = solution(fees, records);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }

    }
    public static int[] solution(int[] fees, String[] records) {
        for (String record : records) {
            String[] recordInfo = record.split(" "); //05:34, 5961, IN
            String time = recordInfo[0];
            String carNumber = recordInfo[1];
            String action = recordInfo[2]; // "IN" or "OUT"

            Car car = carMap.getOrDefault(carNumber, new Car(carNumber, 0, false)); // CarMap에 존재하지 않는 차인 경우 새로 생성
            if (action.equals("IN")) {
                car.parking(time); // 주차 시키기
            } else if (action.equals("OUT")) {
                car.exit(time); // 출차 시키기
            }

            carMap.put(carNumber, car); // 변경된 상태 저장
        }

        List<Car> cars = new ArrayList<>();
        for (String carNumber : carMap.keySet()) {
            cars.add(carMap.get(carNumber)); // 정렬을 위한 리스트로 변환
        }

        Collections.sort(cars); // 정답은 차량 번호판이 작은 순서로 나가야 함

        int[] answer = new int[cars.size()];
        int i = 0;
        for (Car car : cars) {
            car.calculateParkingFee(fees); // 차 마다 주차비 계산
            answer[i++] = car.parkingFee;
        }
        return answer;
    }
}

class Car implements Comparable<Car> {
    String carNumber;
    int parkingAmount;
    LocalTime parkedAt;
    boolean isParking;

    int parkingFee;

    public Car(String carNumber, int parkingAmount, boolean isParking) {
        this.carNumber = carNumber;
        this.parkingAmount = parkingAmount;
        this.isParking = isParking;
    }

    public void parking(String time) {
        isParking = true;
        parkedAt = LocalTime.parse(time); //주차 시간 저장
    }

    public void exit(String time) {
        isParking = false;
        LocalTime exitAt = LocalTime.parse(time);

        int amount = (int) Duration.between(parkedAt, exitAt).toMinutes(); //Duration, LocalTime을 통해 문자열로 주어진 시간의 차(분)를 구함
        parkingAmount += amount;
    }

    public void calculateParkingFee(int[] fees) {
        int basicTime = fees[0];
        int basicPrice = fees[1];
        int unitTime = fees[2];
        int unitPrice = fees[3];

        if (this.isParking) { // 하루가 지났는데, 출차 기록이 없는 경우 "23:59"분에 출차한걸로 간주
            exit("23:59");
        }

        if (parkingAmount > 0) { // 주차를 했다면 기본요금
            parkingFee += basicPrice;
            parkingAmount -= basicTime; // 기본요금 지불 후 기본 시간 차감
        }

        if (parkingAmount > 0) { // 기본 시간 이상으로 주차 한 경우
            int units = parkingAmount / unitTime;
            parkingFee += units * unitPrice; // 단위 시간 만큼 주차비 지불
            if (parkingAmount % unitTime != 0) { // 단위 시간 보다 남는 경우 올림해서 더함
                //ex) unitTime = 10, parkingAmount = 23 => [20 | 3] 으로 총 30분에 대하여 지불해야함
                parkingFee += unitPrice;
            }
        }
    }

    @Override
    public int compareTo(Car o) { // 차량 번호판 오름차순으로 정렬
        return this.carNumber.compareTo(o.carNumber);
    }
}
