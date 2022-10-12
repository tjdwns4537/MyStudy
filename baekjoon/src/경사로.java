import java.util.Scanner;

public class 경사로 {

    // 백준 코드로 제출시 Main 으로 제출

    // 입력
    static int N, L;
    static int answer = 0;
    static int[][] road;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();

        road = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                road[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            answer += roadCol(i) + roadRow(i);
        }

        System.out.println(answer);
    }

    public static int roadCol(int idx) {

        int[] Buffer = new int[N]; // 초기값 : 0

        // 만약 배열이 차이가 없는 경우에는 초기 값이 그대로 유지됨

        for (int i = 0; i < N; i++) {

            //높이 차이가 2이상 나는 경우
            try {
                if (road[idx][i] >= road[idx][i + 1] + 2) {
                    return 0;
                }
                if (road[idx][i] <= road[idx][i + 1] - 2) {
                    return 0;
                }

                if (road[idx][i] > road[idx][i + 1]) { // 내리막
                    int start = i + 1;
                    int j;
                    for (j = start; j < start + L; j++) {
                        if (j >= N) return 0; // 범위를 벗어난 경우
                        if (road[idx][i + 1] == road[idx][j]) { // 다음 블럭의 높이가 같은 경우 버퍼에 넣어줌
                            Buffer[j]++;
                        } else return 0;
                    }
                }
                else if (road[idx][i] < road[idx][i + 1]) { // 오르막
                    int start = i;
                    int j;
                    for (j = start; j > start - L; j--) {
                        if (j < 0) return 0; // 범위가 넘으면 종료
                        if (road[idx][i] == road[idx][j]) {
                            Buffer[j]++;
                        } else return 0;
                    }
                }
            } catch (Exception e) {

            }
        }

        for (int i = 0; i < N; i++) {
            if(Buffer[i] > 1) return 0;
        }

        return 1;
    }

    public static int roadRow(int idx) {
        int[] buffer = new int[N];

        for (int i = 0; i < N; i++) {
            try {
                if (road[i][idx] >= road[i + 1][idx] + 2) {
                    return 0;
                }
                if (road[i][idx] <= road[i + 1][idx] - 2) {
                    return 0;
                }

                if (road[i][idx] > road[i + 1][idx]) { // 오르막
                    int start = i + 1;
                    for (int j = start; j < start + L; j++) {
                        if (j >= N) return 0;
                        if (road[i + 1][idx] == road[j][idx]) {
                            buffer[j]++;
                        } else return 0;
                    }
                }

                if (road[i][idx] < road[i + 1][idx]) { // 내리막
                    int start = i;
                    for (int j = start; j > start - L; j--) {
                        if (j < 0) return 0;
                        if (road[i][idx] == road[j][idx]) {
                            buffer[j]++;
                        } else return 0;
                    }
                }
            } catch (Exception e) {

            }
        }

        for (int i = 0; i < N; i++) {
            if(buffer[i] > 1) return 0;
        }

        return 1;
    }
}
