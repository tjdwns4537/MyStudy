import java.io.*;

public class test5 {
    /**
     - 문제 :
     최소한의 조작으로 자물쇠를 풀지 않을 경우 자물쇠가 파괴됨
     최소한의 방법으로 자물쇠를 열 수 있는 방법을 찾아라

     1) 다이얼은 왼쪽 또는 오른쪽으로 돌릴 수 있음
     2) 돌려 선택한 문자가 화살표 아래에 놓이도록 하고, 다이얼 누르면 해당 문자 선택됨
     3) 1회 조작이란 :
        - 다음 문자를 선택하기 위해 왼쪽/오른쪽으로 한칸 돌림
        - 12시 방향에 위치한 버튼을 눌러 문자를 선택

     - 다이얼 구성 :
     1) 임의의 알파벳 문자열로 구성
     2) 문자열에는 중복된 문자 없음
     3) 입력 문자열은 12시 방향부터 시계방향으로 배치됨

     - 입력 :
     1) 다이얼 구성을 위한 문자열 입력
        - 알파벳만 입력 ( 길이 : 7 ~ 51 | 대소문자 구분 )
     2) 비밀번호 입력
        - 알파벳만 입력 ( 길이 : 2 ~82 | 다이얼 구성 문자로만 구성 )

     - 출력 :
     최소 작업 횟수 ( 왼 + 오 + 비밀번호 수 ), 왼쪽으로 돌린 횟수, 오른쪽으로 돌린 횟수

     **/

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String pw = br.readLine();

        cal(pw,input);
    }

    public static void cal(String pw, String input) {
        int leftMove = 0;
        int leftTemp = 0;
        int rightMove = 0;
        int rightTemp = 0;
        int selectInx = 0;
        for (int i = 0; i < pw.length(); i++) {
            for (int j = 0; j < input.length(); j++) {
                if(pw.charAt(i) == input.charAt(j)){
                    selectInx = j;
                    break;
                }
            }
            leftTemp = selectInx;
            rightTemp = input.length() - selectInx;
            if(leftTemp < rightTemp) leftMove = leftTemp;
            else rightMove = rightTemp;
        }

        int total = pw.length() + leftMove + rightMove;
        System.out.println(total + " " + leftMove + " " + rightMove);
    }
}
