import java.util.Arrays;

public class 주식가격 {
    /**
     * TODO
     *  - 초 단위 주식 가격이 있는 배열에서 가격이 떨어지지 않은 기간을 몇 초인가
     *
     * **/

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 3};
        int[] solution = solution(arr);
        System.out.println(Arrays.toString(solution));

    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int time = 0;
            for (int j = i+1; j < prices.length; j++) {
                time++;
                if(prices[i] > prices[j]) break;
            }
            answer[i] = time;
        }

        return answer;
    }
}
