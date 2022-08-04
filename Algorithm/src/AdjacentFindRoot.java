import java.util.LinkedList;
import java.util.Queue;

public class AdjacentFindRoot {
    public static void main(String[] args) {
        /*
        - 인접 행렬에서 한 정점으로 부터 다른 정점으로 이어지는 길이 존재하는지 반환
        - 입력 : 2차원 배열, 시작정점, 도착정점
        - 출력 : 시작정점에서 도착 정점으로 가는 길이 있으면 true 를 반환
         */

        int[][] test = new int[][]{
                {0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
        };
        boolean directions = getDirections(test, 1, 4);
        System.out.println(directions);
    }

    public static boolean getDirections(int[][] matrix, int from, int to) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);

        boolean[] visited = new boolean[matrix.length];
        visited[from] = true;

        while(queue.size() > 0){
            int now = queue.poll();
            if(now == to) return true;

            for (int i = 0; i < matrix[now].length; i++) {
                if (matrix[now][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return false;
    }
}
