import java.util.ArrayList;

public class skillCheck2 {
    /**
     - 문제 해석
     > 일렬로 줄 서 있음
     > 1~n 까지 번호가 매겨져 있음
     > n명의 사람이 줄 서는 방법은 여러가지 있음
     > 사람의 수 n, 자연수 k가 주어질 때, 사람을 나열하는 방법을 사전순으로 정렬
     > k번째 정렬된 수의 배열을 리턴
     **/
    public static void main(String[] args) {

    }
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();

        int fn = 1;
        for (int i = 1; i <= n; i++) {
            fn *= i; // fac 구하기
            list.add(i);
        }
        k--;
        int idx = 0;
        while (idx < n) {
            fn /= n - idx;
            answer[idx++] = list.remove((int) (k / fn));
            k %= fn;
        }

        return answer;
    }
}
