public class 피보나치수열 {

    /*
    - 문제 : 숫자 n이 주어지고, 그 수를 1234567 로 나눈 나머지를 리턴하는 함수를 작성해라

    * */
    public static void main(String[] args) {
        System.out.println(solution(3));
    }

    public static int solution(int n) {
        int[] answer = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            if(i==0) answer[i] = 0;
            else if(i==1) answer[i] = 1;
            else{
                int sum = answer[i-2] + answer[i-1];
                answer[i] = sum % 1234567;
            }
        }

        return answer[n];
    }

}
