import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FarNode {
    /**

     - 문제 이해하기
     n개의 노드 그래프
     1~n까지의 각 노드
     1번 노드에서 가장 멀리 떨어진 노드의 갯수구하기
     가장 멀리 떨어진 노드란 최단 경로로 이동했을 때 간선의 개수가 가장 많은 노드

     - 해결 과정
     * bfs를 활용해 이동 경로 확인
     1) 각 노드별 depth를 저장하는 visit를 설정
     2) 이를 통해 노드에 depth를 저장

    **/

    private static ArrayList<Integer>[] adj;
    private static int[] visit;
    private static int depth = 0;
    private static int answer = 0;

    public static void main(String[] args) {
        int n = 6;
        int[][] egdes = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
        solution(n, egdes);
        System.out.println(answer);
    }

    public static int solution(int n, int[][] edge) {
        answer = 0;

        visit = new int[n + 1]; // 정점 갯수만큼의 방문 배열 만들기
        adj = new ArrayList[n+1]; // 인접리스트 생성

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) { // 노드 연결
            adj[edge[i][0]].add(edge[i][1]);
            adj[edge[i][1]].add(edge[i][0]);
        }

        bfs(1, 1); // 시작 정점을 넣어줌

        for (int i = 1; i <= n; i++) { // 그래프 정점이 1부터 시작
            if(depth == visit[i]) answer++;
        }

        return answer;
    }

    public static void bfs(int start,int count) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        q.add(count);
        visit[start] = count;

        while (!q.isEmpty()) {
            int node = q.poll();
            int n = q.poll();

            if(depth<n) depth = n; // 가장 깊은 노드를 구함
            for (int i = 0; i < adj[node].size(); i++) {
                int next = adj[node].get(i); // 다음 정점을 방문함
                if(visit[next] != 0) continue; // 연결 간선이 없는 경우
                visit[next] = n + 1; // 방문할때마다 카운트 증가
                q.add(next); // 다음 방문할 연결된 정점
                q.add(n + 1);
            }
        }
    }
}
