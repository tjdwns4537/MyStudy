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

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        solution(fees, records);

    }
    public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        Map<String, String> recordCar = new HashMap<>();
        Map<Integer, Integer> resultPriceCar = new HashMap<>();

        for (String i : records) {
            String[] recordParsing = i.split(" "); // [05:32, 5961, IN]
            if(recordParsing[2].equals("IN")) recordCar.put(recordParsing[1], recordParsing[0]);
            if(recordParsing[2].equals("OUT")) { // [07:59, 5961, OUT]
                Integer time = calTime(recordParsing, recordCar);
                Integer price = calPrice(fees, time);
                resultPriceCar.put(Integer.valueOf(recordParsing[1]), price);
            }
        }

        List<Integer> list = new ArrayList<>(resultPriceCar.keySet());
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static Integer calTime(String[] recordParsing, Map<String,String> recordCar) {
        String outCarTime = recordParsing[0];
        String outCarName = recordParsing[1];

        String inCarTime = "";

        Integer resultCarTime = 0;

        if(recordCar.containsKey(outCarName)){// 05:32 -> 05,32
            inCarTime = recordCar.get(outCarName);
            Integer[] outCar = Arrays.stream(outCarTime.split(":")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
            Integer[] inCar = Arrays.stream(inCarTime.split(":")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
            Integer hour = (outCar[0] - inCar[0]) * 60;
            Integer minute = outCar[1] - inCar[1];
            resultCarTime = hour + minute;
        }

        return resultCarTime;
    }

    public static Integer calPrice(int[] fees, Integer time) {
        Integer resultPrice = 0;

        int baseTime = fees[0]; // 기본시간
        int basePrice = fees[1]; // 기본요금
        int unitTime = fees[2]; // 단위시간
        int unitPrice = fees[3]; // 단위요금

        int plusTime = time - baseTime; // 전체 시간 - 기본 시간
        double ceilTime = Math.round(Double.parseDouble(String.valueOf(plusTime / unitTime)));
        resultPrice = basePrice + Integer.parseInt(String.valueOf(ceilTime)) * unitPrice;

        return resultPrice;
    }
}
