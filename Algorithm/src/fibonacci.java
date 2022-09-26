public class fibonacci {
    static long[] memo;
    public static int fibonacci_rec(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci_rec(n-1) + fibonacci_rec(n-2);
        }
    }

    public static long fibonacci_memoization(int n) {
        if (n <= 1) {
            return n;
        }
        else if(memo[n] != 0){
            return memo[n];
        }
        else {
            return memo[n] = fibonacci_memoization(n - 1) + fibonacci_memoization(n - 2);
        }
    }

    public static int bottomUp(int n){
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        if(n==0) return arr[0];
        else if(n==1) return arr[1];
        else{
            for(int i=2; i<=n; i++){
                arr[i] = arr[i - 1] + arr[i - 2];
            }
            return arr[n];
        }
    }
    public static void main(String[] args) {
        memo = new long[10];
        System.out.println(fibonacci_rec(10));
        System.out.println(fibonacci_memoization(10));

    }
}
