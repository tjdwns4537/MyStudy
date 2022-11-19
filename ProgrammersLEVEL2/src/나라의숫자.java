public class 나라의숫자 {

    /**
     - 문제 :
     124 나라에서는 10진법이 아닌 자신만의 규칙으로 수를 표현
     1) 자연수만 존재
     2) 모든 수를 표현할 때, 1/2/4 만 사용
     ex. 3 = 4, 4 = 11, 5 = 12, 6 = 14 ...

     - 출력:
     n 이 입력됬을 때, 124 나라에서 사용하는 숫자로 바꾼 값을 반환해라

     **/

    public static void main(String[] args) {
        System.out.println(solution(5));
    }

    public static String solution(int n) {
        String answer = "";
        int div = n / 3;
        if(div%3 == 0){
            if(n%3 == 0) answer += 4;
            if(n%3 == 1) answer += 1;
            if(n%3 == 2) answer += 2;
        }
        if(div%3 == 1){
            answer += 1;
            n -= 3;
            if(n%3 == 0) answer += 4;
            if(n%3 == 1) answer += 1;
            if(n%3 == 2) answer += 2;
        }
        if(div%3 == 2){
            answer += 2;
            n -= 6;
            if(n%3 == 0) answer += 4;
            if(n%3 == 1) answer += 1;
            if(n%3 == 2) answer += 2;
        }

        return answer;
    }
}
