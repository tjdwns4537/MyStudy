import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class postfix {

    public static Stack<Character> stack = new Stack();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(postfix(input));
    }

    public static int priority(char ch) {
        if(ch=='+' || ch=='-'){
            return 0;
        }
        else if(ch=='*' || ch=='/'){
            return 1;
        }
        else return -1;
    }

    public static String postfix(String input) {
        String str = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(('0'<=ch && ch<='9') || ch == '.'){
                str += ch;
            }
            else if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')'){
                while(!stack.empty()){
                    char stackChar = stack.pop();
                    if(stackChar == '('){
                        break;
                    }
                    else {
                        str += stackChar;
                    }
                }
            }

            else if(ch =='*' || ch =='+' || ch =='-' || ch == '/'){
                if(stack.empty()){
                    stack.push(ch);
                } else{
                    int op1 = priority(ch); // 입력 연산자 우선순위
                    int op2 = priority(stack.peek()); // 스택 연산자 우선순위

                    if(op1 <= op2){
                        str += stack.pop();
                    } else {
                        stack.push(ch);
                    }
                }
            }
        }

        while(!stack.empty()){
            str += stack.pop();
        }

        return str;
    }
}
