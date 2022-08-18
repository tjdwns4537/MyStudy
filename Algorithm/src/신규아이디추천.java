import java.util.Locale;

public class 신규아이디추천 {
    /*
    - 해야할 일
    1) 규칙에 맞지 않는 아이디를 입력했을 때, 입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천

    - 아이디 규칙
    1) 길이: 3 ~ 15
    2) 사용가능 문자 : 소문자, 빼기, 밑줄, 마침표
    3) 단, 마침표는 시작과 끝에 사용 불가능, 연속으로 사용 불가능

    - 해야할 일의 처리 과정
    1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
    2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
    3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
    4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
    5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
    6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
         만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
    7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
  능  */
    public static void main(String[] args) {
        String newId = 	"00.@cdefgTWhijklm...!_I',"	;
        String solution = solution(newId);

        System.out.println("res: " + solution);
    }

    public static String solution(String new_id) {
        String answer = "";
        String one = "";
        String two = "";
        String three = "";
        String four = "";
        String five = "";
        String six = "";
        String seven = "";

        // 1
        one = new_id.toLowerCase(Locale.ROOT);

        char[] ch = one.toCharArray();

        // 2
        for (int i = 0; i < ch.length; i++) {
            if(('a'<= ch[i] && ch[i] <= 'z') || ('0' <= ch[i] && ch[i] <= '9') ||
                    (ch[i]=='-') || (ch[i] =='_') || (ch[i] == '.')){
                two += ch[i];
            } else {
                continue;
            }
        }

        // 3
        three = two;
        while(three.contains("..")){
            three = three.replace("..", ".");
        }

        //4
        four = three;
        if (four.length() > 0 && four.charAt(0) == '.') {
            four = four.substring(1, four.length());
        }
        if (four.length() > 0 && four.charAt(four.length() - 1) == '.') {
            four = four.substring(0, four.length() - 1);
        }

        //5
        five = four;
        if (five.isEmpty()) {
            five = "a";
        }

        //6
        six = five;
        if(six.length() > 15){
            six = six.substring(0, 15);
            if(six.substring(six.length()-1,six.length()).equals(".")){
                six = six.substring(0,six.length()-1);
            }
        }

        //7
        seven = six;
        while(seven.length()<=2){
            ch = seven.toCharArray();
            seven += ch[ch.length-1];
        }

        answer = seven;
        return answer;
    }
}
