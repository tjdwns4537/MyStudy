import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 두큐값같게만들기 {

    /**
     *  TODO
     *      - 두 큐의 전체 합 구하기
     *      - 큐1에서 합/2 를 맞추기 위해 pop,insert
     *      - 반복
     * **/
    static int half;

    public static void main(String[] args) {

    }

    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int sum1 = Arrays.stream(queue1).sum();
        int sum2 = Arrays.stream(queue2).sum();
        int totalSum = sum1 + sum2;
        half = totalSum/2;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i : queue1) {
            q1.add(i);
        }
        for (int i : queue2) {
            q2.add(i);
        }

        answer = compare(sum1,q1,q2);

        return answer;
    }

    public int compare(int sum, Queue<Integer> q1, Queue<Integer> q2) {
        int cnt = 0;

        while (sum != half) {
            if(sum < half){
                int minus = q2.poll();
                q1.add(minus);
                sum += minus;
                cnt++;
            }
            else if (sum > half) {
                int minus = q1.poll();
                q2.add(minus);
                sum -= minus;
                cnt++;
            }
        }
        return cnt;
    }
}
