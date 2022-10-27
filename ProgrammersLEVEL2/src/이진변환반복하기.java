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
        String[] split;
        int deleteZero = 0;
        int doNum = 1;

        while(true){

            if(s.split("0").equals(s)) break; // 0이 없는 것은 종료
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    deleteZero++;
                }
            }

            split = s.split("0");
            int splitNum = split.length-1;
            if(splitNum <= 1) break;
            s = "";

            while(splitNum > 1){
                if((splitNum%2)==1) s += 1;
                else s += 0;
                splitNum/=2;
            }
            s += 1;
            System.out.println("output : "+s);
            doNum++;
        }

        answer[0] = doNum;
        answer[1] = deleteZero;
        return answer;
    }
}
