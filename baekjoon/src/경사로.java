import java.util.Scanner;

public class 경사로 {
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
            if(roadCol(i) || roadRow(i)){
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean roadCol(int idx) {
        int[] Buffer = new int[N];
        for (int i = 0; i < N; i++) {

            //높이 차이가 2이상 나는 경우
            if (road[idx][i] >= road[idx][i + 1] + 2) {
                return false;
            }
            if (road[idx][i] >= road[idx][i + 1] - 2) {
                return false;
            }

            // 내리막
            if (road[idx][i] > road[idx][i + 1]) {
                int start = i + 1;
                int j;
                for (j = start; j < start + L; j++) {
                    if(j>=N) return false; // 범위를 벗어난 경우
                    if (road[idx][i + 1] == road[idx][j]) { // 다음 블럭의 높이가 같은 경우 버퍼에 넣어줌
                        Buffer[j]++;
                    }
                    else return false;
                }
            }

            // 오르막
            if (road[idx][i] < road[idx][i + 1]) {
                int start = i + 1;
                int j;
                for (j = start; j < start; j++) {
                    if(j>=N) return false;
                    if (road[idx][i + 1] == road[idx][j]) {
                        Buffer[j]++;
                    }
                    else return false;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if(Buffer[i] > 1) return false;
        }

        return true;
    }

    public static boolean roadRow(int idx) {
        int[] buffer = new int[N];

        for (int i = 0; i < N; i++) {
            if (road[i][idx] >= road[i + 1][idx] + 2) {
                return false;
            }
            if (road[i][idx] >= road[i + 1][idx] - 2) {
                return false;
            }

            if (road[i][idx] > road[i + 1][idx]) {
                int start = i + 1;
                for (int j = start; j < start + L; j++) {
                    if(j>=N) return false;
                    if (road[i + 1][idx] == road[j][idx]) {
                        buffer[j]++;
                    }
                    else return false;
                }
            }

            if (road[i][idx] < road[i + 1][idx]) {
                int start = i + 1;
                for (int j = start; j < start + L; j++) {
                    if(j>=N) return false;
                    if (road[i + 1][idx] == road[j][idx]) {
                        buffer[j]++;
                    }
                    else return false;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if(buffer[i] > 1) return false;
        }

        return true;
    }
}
