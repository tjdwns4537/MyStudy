import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    /**
     * TODO
     *  - 트럭 여러대가 일차선 도로를 건너는데 걸리는 최소한의 시간
     *  - 큐를 활용
     *  - 큐에 들어올 때만 시간을 +1
     *  - 나갈 때는 시간이 올라가지 않음
     *  1) 트럭이 들어오기 전에 bridge_length 조건 확인
     *  2) 큐에 있는 트럭의 무게가 weight를 넘지 않는지 확인
     * **/

    public static void main(String[] args) {
        int len = 100;
        int weight = 100;
        int[] arr = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int solution = solution(len, weight, arr);
        System.out.println(solution);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer;
        int sum = 0;
        int time = 0;

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            int truckWeight = truck_weights[i];
            while(true){
                if(bridge_length <= queue.size()) sum -= queue.poll();
                if (weight >= sum + truckWeight) {
                    queue.add(truckWeight);
                    sum += truckWeight;
                    time++;
                    break;
                }
                queue.add(0);
                time++;
            }
        }

        answer = bridge_length + time;
        return answer;
    }
}
