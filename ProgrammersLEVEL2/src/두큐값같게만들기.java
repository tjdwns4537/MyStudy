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
    static long totalSum;

    public static void main(String[] args) {
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        int solution = solution(queue1, queue2);
        System.out.println(solution);
    }

    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i< queue1.length; i++) {
            totalSum += queue1[i];
            sum1 += queue1[i];
            totalSum += queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }

        totalSum /= 2;

        answer = compare(queue1.length*3,sum1,q1,q2);

        return answer;
    }

    public static int compare(int len, long sum1, Queue<Integer> q1, Queue<Integer> q2) {
        int maxCount = len;

        while (sum1 != totalSum) {
            if(maxCount == 0) return -1;
            if(sum1 < totalSum){
                int minus = q2.poll();
                q1.add(minus);
                sum1 += minus;
            }
            else {
                int minus = q1.poll();
                q2.add(minus);
                sum1 -= minus;
            }
            maxCount--;
        }

        return len - maxCount;
    }
}
