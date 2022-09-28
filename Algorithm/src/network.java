public class network {
    /**
    - 컴퓨터 개수 n
    - 연결에 대한 정보가 담긴 2차원 배열 (computer)
     - 출력 : 네트워크 개수
    **/
    public static void main(String[] args) {
        int n = 3;
        int[][] computer1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] computer2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        System.out.println("test1 : " + solution(n, computer1));
        System.out.println("test2 : " + solution(n, computer2));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[computers.length];
        for (boolean i : check) {
            i = false;
        }

        for (int i = 0; i < computers.length; i++) {
            if (check[i] == false) {
                dfs(computers, i, check);
                answer++;
            }
        }
        return answer;
    }

    public static boolean[] dfs(int[][] computers, int n, boolean[] check) {
        // n : 방문 노드, computer : 네트워크 배열, check : 방문했는지 확인하는 배열
        check[n] = true;
        for (int i = 0; i < computers.length; i++) {
            if(n != i && computers[n][i] == 1 && check[i] == false){
                // n != i : 방문 할 노드의 인덱스와 방문한 노드가 같지 않음
                // computer[n][i] : 네트워크 배열에서 이제 방문할 배열 원소가 1인 경우
                // check[i] == false : 아직 방문 하지 않은 경우
                check = dfs(computers, i, check);
            }
        }
        return check;
    }
}
