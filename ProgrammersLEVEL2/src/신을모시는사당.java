import java.util.Scanner;

public class 신을모시는사당 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stones = new int[n];
        for (int i = 0; i < n; i++) {
            int direction = sc.nextInt();
            if (direction == 1) {
                stones[i] = 1;
            } else {
                stones[i] = -1;
            }
        }


        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

//        int currentSum = stones[0];
//        int prevSum = 0;
//        int maxSum = 0;
//        for (int i = 0; i < n; i++) {
//            prevSum = currentSum;
//            currentSum = stones[i];
//            if(prevSum != currentSum) maxSum += 1;
//        }

        for (int i = 0; i < n; i++) {
            currentSum += stones[i];
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        System.out.println(Math.abs(maxSum));
    }
}
