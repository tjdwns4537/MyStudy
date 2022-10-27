import java.util.ArrayList;
import java.util.Arrays;

public class 영어끝말잇기 {
    /**
    - 문제 설명: 1 ~ n까지 번호가 붙어 있는 n명의 사람이 영어 끝말잇기 진행
     1) 1번부터 번호순으로 차례대로 단어 말함
     2) 마지막 사람이 단어를 말한 다음 다시 1번부터 시작
     3) 앞 사람이 말한 단어의 마지막 문자로 시작하는 단어 말함
     4) 이전에 등장했던 단어는 사용 못함
     5) 한 글자 단어는 사용 금지

     - 출력 :
     가장 먼저 탈락하는 사람의 번호, 그 사람이 몇 번째에 탈락하는지를 구함

     - 조건 :
     1) 단어길이 - 2~50
     2) 배열길이 - n ~ 100이하
     3) 소문자
     4) 탈락자가 생기지 않는다면 0,0 반환

     - 해결 방법 :
     1) 경우에 대한 조건문 작성
     2) 번호 : i+1 % n
     3) 몇 번째 차례 : i / n 보다 큰 첫번째 정수

     **/
    public static void main(String[] args) {
        String[] input = {"hello", "one", "even", "never", "now", "world", "draw"};
        String result = Arrays.toString(solution(2, input));
        System.out.println(result);

    }

    public static int[] solution(int n, String[] words) {
        ArrayList<String> arr = new ArrayList<>();
        int[] answer = new int[2];
        String prev = words[0];
        arr.add(words[0]);

        for(int i=1; i<words.length; i++){
            char CanFirstLetter = prev.charAt(prev.length()-1);
            if(words[i].length() == 1){
                System.out.println("issue oneLetter: "+i);
                answer[0] = (i % n) + 1;
                answer[1] = (i/n)+1;
                return answer;
            }
            if(CanFirstLetter != words[i].charAt(0)){
                System.out.println("issue not: "+i);
                answer[0] = (i % n) + 1;
                answer[1] = (i/n)+1;
                return answer;
            }
            if (arr.contains(words[i])) {
                System.out.println("issue contain: "+i);
                answer[0] = (i % n) + 1;
                answer[1] = (i/n)+1;
                return answer;
            }

            prev = words[i];
            arr.add(words[i]);
        }

        answer[0] = 0;
        answer[1] = 0;
        return answer;
    }
}
