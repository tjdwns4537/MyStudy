public class compareString {

    /**
    - 문제
     : 대소문자가 섞여 있는 문자열 s가 존재
     s에 'p'의 개수, 'y'의 개수를 비교해 같으면 True, 아니면 false
     만약 하나도 없는 경우 true 리턴
     대소문자를 구별하진 않음
    **/
    public static void main(String[] args) {
        String test = "pPoooyY";
        boolean solution = solution(test);
        System.out.println(solution);
    }

    static boolean  solution(String s) {
        boolean answer = true;
        int pCnt = 0;
        int sCnt = 0;

        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if(ch[i] == 'p' || ch[i] == 'P'){
                pCnt++;
            } else if (ch[i] == 'y' || ch[i] == 'Y') {
                sCnt++;
            }
        }

        if (pCnt != sCnt) {
            answer = false;
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}
