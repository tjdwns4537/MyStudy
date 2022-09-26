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
        solution(triangle);
    }

    public static int solution(int[][] triangle) {
        int answer = 0;
        int maxSum = 0;


        return answer;
    }
}
