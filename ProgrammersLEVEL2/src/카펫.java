import java.util.ArrayList;

public class 카펫 {

    /**
    - 문제 해석:
     갈색 격자수, 노란색 격자 수 yellow 가 매개변수로 주어질 때,
     카펫의 가로/세로 크기를 수너대로 담은 배열을 나타내라

     - 단, 중앙에는 노란색, 테두리 1줄은 갈색으로 칠해져 있음

     - 풀이 방법:
     1) 갈색,노란색 격자 수를 더한 값의 약수를 구한다.
     2) 그 약수 중에 정답이 있다.
     3) (가로-2) * (세로-2) = 노란색의 개수이다.

     * 조건
     - 가로 길이 >= 세로 길이
     - 가운데에 노란색 격자가 위치하기 위해선 가로,세로 길이가 모두 3 이상
    **/

    static int brown;
    static int yellow;

    public static void main(String[] args) {
        brown = 10;
        yellow = 2;
        int[] solution = solution();
        System.out.println(solution[0] + " " + solution[1]);
    }

    public static int[] solution() {
        int[] answer = new int[2];
        int sum = brown + yellow;
        // 더한 덧셈 결과를 약수 구하기 함수에 넣어줌

        for (int i = 3; i <= sum; i++) {
            int j = sum/i;
            if (sum % i == 0 && j >= 3) {
                int col = Math.max(i, j);
                int row = Math.min(i, j);

                if ((col - 2) * (row - 2) == yellow) {
                    answer[0] = col;
                    answer[1] = row;
                    return answer;
                }
            }
        }
        return answer;
    }
}
