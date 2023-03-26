public class 가장큰정사각형찾기 {

    /**
     * TODO
     *  - 목표: 가장 큰 정사각형을 찾아라
     *  - DB 알고리즘 활용
  장  * **/

    public static void main(String[] args) {
        int[][] arr = {{0, 0, 1, 1}, {1,1,1,1}};
        int solution = solution(arr);
        System.out.println(solution);
    }

    public static int solution(int [][]board)
    {
        int answer = 0;

        int[][] map = new int[board.length + 1][board[0].length + 1];

        int maxLen = 0;
        for (int i = 1; i <= board.length; i++) {
            for (int j = 1; j <= board[0].length; j++) {
                if(board[i-1][j-1] != 0) {
                    int min = Math.min(Math.min(map[i - 1][j], map[i][j - 1]), map[i - 1][j - 1]);
                    map[i][j] = min + 1;

                    maxLen = Math.max(maxLen, min + 1);
                }
            }
        }

        return maxLen * maxLen;
    }
}
