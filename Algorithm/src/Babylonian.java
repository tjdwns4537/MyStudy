public class Babylonian {
    private double x,m;
    private double result;
    private int count;
    private double guess;

    // 근사값 구하기
    public double computeRoot(double a) {
        x = a;
        m = 0;
        while (m <= x) {
            // 제곱했을 때 딱 떨어진다면 바로 리턴
            // 제곱했을 때 수가 더 커진다면 제곱한 수의 -1을 리턴
            result = Math.floor((m+x) / 2);
            if (result * result > x) {
                x = result - 1;
            }
            else {
                m = x + 1;
            }
        }
        return x;
    }

    // 바빌로니아 공식
    public double BL(double num) {
        guess = computeRoot(num);
        if((num * num) == x) return num;
        while (guess * guess < num ) {
            guess += 0.01;
        }
        return guess;
    }
}
