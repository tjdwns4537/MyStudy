import java.util.Scanner;

public class 경사로 {
    public static void main(String[] args) {

        // 입력
        int input1, input2;
        Scanner sc = new Scanner(System.in);
        input1 = sc.nextInt();
        input2 = sc.nextInt();

        int[][] arr = new int[input1][input1];

        for (int i = 0; i < input1; i++) {
            for (int j = 0; j < input2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int result = road(arr);
        System.out.println(result);
    }

    public static int road(int[][] arr) {
        int returnCnt = 0;

        return returnCnt;
    }
}
