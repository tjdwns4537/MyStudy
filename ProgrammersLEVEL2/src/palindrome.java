public class palindrome {

    /**
     - 문제:
     뒤집었을 때 똑같은 문자열의 길이를 구해라.

     **/

    public static void main(String[] args) {
        String s = "abbaabcdba";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        for (int i = s.length(); i > 0; i--) {
            for (int j = 0; j + i <= s.length(); j++) {
                if(isPalindrome(s,j,j+i-1)) return i;
            }
        }
        return 0;
    }

    public static boolean isPalindrome(String str, int start, int end) {
        while (start <= end) {
            if(str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }

}
