public class triangle {

    /**
     - 출력: 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾는다.
     - 조건: 아래 칸으로 이동할 때에는 대각선 방향으로 한 칸 오른쪽 or 왼쪽으로만 이동 가능

     - 해결 방법:
     [ DFS or DP ]
     1) 맨 왼쪽부터 합을 계산
     2) 맨 끝에 배열부터 시작해 배열 내부 인덱스를 1씩만 줄이면서 계산
     3) 1씩 줄여서 계산 후에는 선택 배열의 인덱스를 1줄이고, 그 배열 내부 인덱스도 1씩 줄인다.
     **/
    public static void main(String[] args) {
        int[][] triangle = {{7},{3, 8},{8, 1, 0},{2, 7, 4, 4},{4, 5, 2, 6, 5}};
        int result = solution(triangle);
        System.out.println("result: "+result);
    }

    public static int solution(int[][] triangle) {
        int answer = 0;

        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0]; // 맨 위에 값을 넣어줌

        for (int i = 1; i < triangle.length; i++) {
            /* 맨 왼쪽 */
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            // 7+3, 7+8, 7+2 와 같이 맨 왼쪽 부분을 더하게 된다.
            // dp[1][0] (10) = dp[0][0] (7) + triangle[1][0] (3) -- 1
            // dp[2][0] (18) = dp[1][0] (10) + triangle[2][0] (8) -- 2

            /* 중간값 */
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
                // dp[1][1] = dp[0][1], dp[0][0] 중에 max + triangle[1][1] (8) -- 1
                // dp[2][1] = dp[1][1], dp[1][0] 중에 max + triangle[2][1] (1)
                // dp[2][2] = dp[1][2], dp[1][1] 중에 max + triangle[2][2] (0) -- 2
            }

            /* 맨 오른쪽 */
//            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
            // dp[1][1] (15) = dp[0][0] (7) + triangle[1][1] (8) -- 1
            // dp[2][2] (15) = dp[1][1] (중간값의 max 값) + triangle[2][2] (1) -- 2
        }

        for (int i = 0; i < triangle.length; i++) {
            answer = Math.max(answer, dp[triangle.length - 1][i]);
        }

        return answer;
    }
}
