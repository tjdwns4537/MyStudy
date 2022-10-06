public class graphDFS {
    private int nV; //정점
    private int[][] dfsGraph; //간선
    private boolean[] visitArr; //방문한 배열

    public graphDFS(int nV) {
        this.nV = nV;

        this.dfsGraph = new int[this.nV + 1][this.nV + 1];
        this.visitArr = new boolean[this.nV + 1];
    }

    // 그래프 리턴
    public int[][] getGraph() {
        return this.dfsGraph;
    }

    // 양방향 그래프 추가
    public void put(int x,int y) {
        this.dfsGraph[x][y] = 1;
        this.dfsGraph[y][x] = 1;
    }

    // 단방향 그래프 추가
    public void putSingle(int x, int y) {
        this.dfsGraph[x][y] = 1;
    }
    //그래프 출력
    public void printGraphToAdjArr() {
        System.out.println("\n"+"[그래프 출력]");
        for (int i = 1; i < dfsGraph.length; i++) {
            for (int j = 1; j < dfsGraph[i].length; j++) {
                System.out.print(this.dfsGraph[i][j]+" ");
            }
            System.out.println();
        }
    }

    // 그래프 탐색
    public void dfs(int vIdx) {
        visitArr[vIdx] = true;
        System.out.print(vIdx + " ");
        for (int i = 1; i <= nV; i++) {
            if(dfsGraph[vIdx][i] == 1 && visitArr[i] == false){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        int nV = 8;

        graphDFS graph = new graphDFS(nV);

        graph.put(1, 2);
        graph.put(1, 3);
        graph.put(2, 4);
        graph.put(2, 5);
        graph.put(3, 6);
        graph.put(3, 7);
        graph.put(4, 8);
        graph.put(5, 8);
        graph.put(6, 8);
        graph.put(7, 8);

        graph.dfs(1);
        graph.printGraphToAdjArr();

    }
}
