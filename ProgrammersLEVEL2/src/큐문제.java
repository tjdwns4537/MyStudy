import java.util.ArrayDeque;
import java.util.Queue;

public class 큐문제 {

    /**

     - 문제 설명:
     길이가 같은 두 개의 큐가 주어짐
     > 하나의 큐를 골라 원소를 추출
     > 추출된 원소를 다른 큐에 집어 넣는 작업을 수행
     > 그 작업을 통해 각 큐의 원소 합을 같게 만듬
     > 이때, 필요한 작업의 최소 횟수를 구해라
     > 한 번씩 pop,insert 를 하면 작업 수행 1회로 간주

     - 주의
     > long type 권장
     > 큐 길이 : 30만
     > 원소 크기 : 10에 9승

     **/

    public static void main(String[] args) {
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        int solution = solution(queue1, queue2);
        System.out.println(solution);

    }

    public static int solution(int[] queue1, int[] queue2) {
        Queue<Integer> que1 = new ArrayDeque<>();
        Queue<Integer> que2 = new ArrayDeque<>();

        long s1 = 0, s2 = 0, sum = 0;

        for (int i = 0; i < queue1.length; i++) {
            que1.add(queue1[i]);
            s1 += queue1[i];

            que2.add(queue2[i]);
            s2 += queue2[i];
        }

        sum = s1 + s2;

        // 홀수가 될 경우 풀 수 없음
        if (sum % 2 == 1) return -1;

        sum = sum/2;

        int problem1 = 0;
        int problem2 = 0;
        int limit = queue1.length * 2;

        while (problem1 <= limit && problem2 <= limit) {
            if(s1 == sum) return problem1 + problem2;
            else if(s1 > sum){
                s1 -= que1.peek();
                s2 += que1.peek();
                que2.add(que1.poll());
                problem1++;
            }
            else {
                s1 += que2.peek();
                s2 -= que2.peek();
                que1.add(que2.poll());
                problem2++;
            }
        }
        return -1;
    }
}
