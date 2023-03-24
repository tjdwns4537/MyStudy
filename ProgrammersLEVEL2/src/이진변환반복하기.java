import java.util.Arrays;

public class 이진변환반복하기 {
    /**
     - 문제 설명
     : 0과 1로 이뤄진 어떤 문자열 x에 대한 이진 변환을 한다.
      1) x의 모든 0을 제거
      2) x의 길이를 c라 하면, x를 "c를 2진법으로 표현한 문자열" 로 바꿈

     **/
    public static void main(String[] args) {
        String s = "110010101001";
        String res = Arrays.toString(solution(s));
        System.out.println(res);

    }
    public static int[] solution(String s) {
        int[] answer = new int[2];

        int cnt = 0;
        int zeroNum = 0;

        while (s.length() > 1) {
            int numLen = 0;
            cnt++;
            System.out.println("str : " + s);
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0') zeroNum++;
                if(s.charAt(i) == '1') numLen++;
            }
            s = Integer.toBinaryString(numLen);
        }

        answer[0] = cnt;
        answer[1] = zeroNum;

        return answer;
    }
}
