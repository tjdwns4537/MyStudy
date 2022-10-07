import java.util.Stack;

public class 괄호문제 {

    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        String s = ")()(";
        System.out.println(solution(s));
    }

    static boolean solution(String s) {
        boolean answer = true;

        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                stack.push(ch[i]);
            } else if (ch[i] == ')') {
                if(stack.empty()){
                    return false;
                }
                Character pop = stack.pop();
            }
        }

        if(!stack.isEmpty()){
            return false;
        }

        return answer;
    }

}