import java.lang.reflect.Array;
import java.util.ArrayList;

public class ComponentCount {
    public static void main(String[] args) {
        int[][] result = {
                {0,1},
                {2,3},
                {4,5}
        };

        int ans = dfs(result);
        System.out.println(ans);
    }

    static int dfs(int[][] edges) {
        int maxV = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        boolean visit[] = new boolean[edges.length];

        // 최대 정점의 개수를 파악
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                if(maxV < edges[i][j]){
                    maxV = edges[i][j];
                }
            }
        }
        int cnt=maxV+1;


        return cnt;
    }
}
