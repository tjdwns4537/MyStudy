public class 다음큰숫자 {

    /**
     - 문제 : n의 다음 튼 숫자를 정의해라
     1) n 보다 큰 자연수
     2) n 을 2진수로 변환했을 때 1의 갯수
     3) 조건 1,2를 만족하는 수 중 가장 작은 수

     - 과정 :
     1) 2진수로 변환 후 갯수 구한다. (k)
     2) n을 증가시키며 k를 비교한다.
     **/

    public static void main(String[] args) {
        System.out.println(solution(78));
    }

    public static int solution(int n) {
        int answer = 0;
        String s = Integer.toBinaryString(n);
        int nLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if('1' == s.charAt(i)) nLen++;
        }

        int oneLen = 0;
        while(n <= 1000000){
            n += 1;
            String s2 = Integer.toBinaryString(n);
            for (int i = 0; i < s2.length(); i++)
                if('1' == s2.charAt(i)) oneLen++;
            if(nLen == oneLen) break;
            oneLen = 0;
        }

        answer = n;
        return answer;
    }
}
