import java.util.Locale;

public class JadenCase문자열만들기 {

    /**
     - 문제:
     모든 단어의 첫 문자가 대문자이고, 그 외 알파벳은 소문자인 문자열입니다.
     단, 첫 문자가 알파벳이 아닐 때는 이어지는 알파벳은 소문자로 쓰면 됩니다.
     문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴해라.

     - 조건:
     > s길이 : 1~200
     > 알파벳과 숫자, 공백문자로 이뤄져 있음
     > 숫자는 단어의 첫 문자로만 나옴
     > 숫자로만 이뤄진 단어는 없음
     > 공백 문자가 연속해서 나올 수 있음

     **/

    public static void main(String[] args) {
        String s1 = "3peoPle unFollowed me 33 ag tT Tt ";
        String s = " aaa aaaa ";

        String solution = solution(s);
        System.out.println(solution);
    }

    public static String solution(String s) {
        String answer = "";

        String[] sp = s.toLowerCase().split("");
        // 모든 단어를 순회합니다.

        boolean flag = true;

        for(String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            // 첫 시작은 당연히 true로 시작해 대문자가 들어감
            // 숫자인 경우는 상관 없음

            flag = ss.equals(" ") ? true : false;
            // 공백을 만나게되기 전까지는 false 가 되므로 소문자로 입력됨
            // 그러다가 공백을 만나게 되면 true로 바뀌고 문자가 입력됨

            // 이렇게 하게 되면 기존에 맨 앞, 맨 뒤에 공백이 있는 문자에 발생하는 에러를 해결 할 수 있다.
        }


        return answer;
    }
}
