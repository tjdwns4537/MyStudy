import java.util.Stack;

public class 괄호문제 {

    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        String s = ")()(";

        System.out.println(solution(s));
    }

    static boolean solution(String s) {
        boolean answer = true;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return answer;
    }
}
