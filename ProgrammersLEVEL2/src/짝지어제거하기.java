import java.util.Stack;

public class 짝지어제거하기 {
    /**
     - 문제 설명:
     > 입력 : 알파벳 소문자로 이뤄진 문자열
     > 과정 :
      1) 문자열에서 같은 알파벳 두 개가 붙어있는 짝을 찾음
      2) 과정을 반복해서 문자열 모두 제거하면 짝지어 제거하기가 종료
      3) 성공적인 수행은 1, 아니면 0 을 리턴

     - 해결 방식:
     1) Stack 활용
     [ 반복문 ]
     2) 문자열을 순회하며 스택에서 peek()한 요소와 현재 순회중인 문자가 같으면 pop
     3) 아니면 push()
     4) 만약 스택이 비어있으면 push
     [ 출력 ]
     5) 만약 스택이 비어 있으면 1 출력
     6) 아니면 0 출력

     **/
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
    }

    public static int solution(String s)
    {
        int answer = -1;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }
            else if (stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        if(stack.isEmpty()) answer = 1;
        else answer = 0;

        return answer;
    }
}
