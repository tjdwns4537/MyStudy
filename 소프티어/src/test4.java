import java.io.*;

public class test4 {
    /**
     - 문제 :
     1) 구성 : 4자리, 버튼 13개 ( 0 ~ 9, *:확인, #:취소, !:호출 )
     2) 기본 구성 : 0000 으로 표시
     3) 경비실 호출 : 기본 구성에서 호출 누름
     4) 공동현관 열기
      - 공동 비밀 번호 입력 후 확인
      - 세대 비밀 번호 사용
        1. 기본 화면에서 세대 번호 입력 후 확인
        2. 화면에 **** 가 표시됨
        3. 세대 비밀번호 입력 후 확인
        4. 무슨 뜻이지
     5) 세대 호출 : 기본 화면에서 세대 호출 입력 후 호출
     6) 입력 오류
        1. 기본 화면으로 돌아감
        2. 공동 비밀번호 오류
        3. 없는 세대 또는 확인 누르기
        4. 비밀번호 입력 중 호출 누르기
     7) 입력 취소
        1. 입력 과정 중 취소 누르면 과정 취소 후 기본 화면으로 돌아감
        2. 공동 현관 열기에서 세대 비밀번호 입력 중 취소 누르면 입력 화면으로 돌아감


     **/
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();


    }
}
