public class 나라의숫자 {

    /**
     - 문제 :
     124 나라에서는 10진법이 아닌 자신만의 규칙으로 수를 표현
     1) 자연수만 존재
     2) 모든 수를 표현할 때, 1/2/4 만 사용
     ex. 3 = 4, 4 = 11, 5 = 12, 6 = 14 ...

     - 출력:
     n 이 입력됬을 때, 124 나라에서 사용하는 숫자로 바꾼 값을 반환해라

     - 공식:
     1) 입력 n이 들어온다.
     2) n의 나머지 3을 구해 k값을 뽑는다.
     3) k 값은 [ 4, 1, 2 ] 배열의 인덱스 값을 의미한다.
     4) n을 3으로 나눠준다.
     5) 이때, 나머지가 0이면 나눠떨어지는 것이므로 n을 3으로 나눈 후 -1을 해준다.

     **/

    public static void main(String[] args) {
        System.out.println(solution(5));
    }

    public static String solution(int n) {
        String answer = "";
        String[] number = {"4", "1", "2"};

        while (n > 0) {
            int reminder = n % 3;
            n /= 3;
            if(reminder == 0) n--;
            answer = number[reminder] + answer;
        }

        return answer;
    }
}
