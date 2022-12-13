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
        int pixIndex = 0;
        int cnt = 0;
        int max = 0;
        for (int i = 1; i < s.length()-1; i++) {
            if(s.charAt(i-1) == s.charAt(i+1)){
                System.out.println("pick1: " + i);
                pixIndex = i;
                cnt = cal(s,pixIndex)*2+1;
                max = Math.max(cnt, max);
            }
            if (s.charAt(i) == s.charAt(i + 1)) {
                System.out.println("pick2: " + i);
                pixIndex = i;
                cnt = cal2(s,pixIndex)*2;
                max = Math.max(cnt, max);
            }
            System.out.println(max);
        }
        return max;
    }

    public static int cal2(String s,int pixIndex) {
        int cnt = 1;
        while(true){
            char left = s.charAt(pixIndex - cnt + 1);
            char right = s.charAt(pixIndex + cnt);
            System.out.println("do: " + left + " " + right);
            if(left != right) break;
            if(pixIndex-cnt < 0 || pixIndex+cnt+1 == s.length()) break;
            cnt++;
        }
        return cnt;
    }

    public static int cal(String s, int pixIndex) {
        int cnt = 1;
        while(true){
            char left = s.charAt(pixIndex - cnt);
            char right = s.charAt(pixIndex + cnt);
            if(left != right) break;
            if(pixIndex-cnt-1 < 0 || pixIndex+cnt+1 == s.length()) break;
            cnt++;
        }
        return cnt;
    }
}
