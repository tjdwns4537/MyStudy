public class MaxMin {

    static String s;
    static String answer;

    public static void main(String[] args) {
        s = "-1 -2 -3 -4";
        String res = solution(s);
        System.out.println(res);
    }

    public static String solution(String _s) {
        answer = "";
        s = _s;

        int Max = -999999999;
        int Min = 999999999;

        String[] sArr = s.split(" ");
        for (String i : sArr) {
            int num = Integer.parseInt(i);
            Max = Math.max(Max, num);
            Min = Math.min(Min, num);
        }

        answer = Min + " " + Max;

        return answer;
    }
}
