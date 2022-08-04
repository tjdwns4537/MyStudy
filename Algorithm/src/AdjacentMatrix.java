public class AdjacentMatrix {
    public static void main(String[] args) {
        /*
        - 방향이 있는 간선과 방향이 없는 간선들의 목록들을 받아 2차원 배열의 인접 행렬을 반환하는 함수를 작성
        - 조건
        1) 0번째 : 간선의 시작 정점
        2) 1번째 : 간선의 도착 정점
        3) 2번째 방향성 ( 1==무향, 0==유향 )
        - 출력
        1) Array type
        2) 2차원 배열 인접 행렬
        - 주의사항
        1) 0 ~ 4로 이어주는 간선이 존재할 경우 1,2,3 정점도 존재합니다.
        2) 두 정점간 간선의 유무는 0과 1로 표시
         */

        int result[][] = new int[][]{
                {0, 3, 0},
                {0, 2, 0},
                {1, 3, 0},
                {2, 1, 0},
        };
        int[][] matrix = createMatrix(result);
        for(int i=0; i< matrix.length; i++){
            for(int j=0; j< matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] createMatrix(int[][] edges){
        // 가장 큰 정점
        int maxLength = 0;

        for(int i=0; i< edges.length; i++){
            for(int j=0; j< 2; j++){
                if(maxLength < edges[i][j]){
                    maxLength = edges[i][j];
                }
            }
        }

        int[][] result = new int[maxLength+1][maxLength+1];

        for(int i=0; i< edges.length; i++){
            if(edges[i][2] == 1){
                result[edges[i][0]][edges[i][1]] = 1;
                result[edges[i][1]][edges[i][0]] = 1;
            } else {
                result[edges[i][0]][edges[i][1]] = 1;
            }
        }

        return result;
    }
}
