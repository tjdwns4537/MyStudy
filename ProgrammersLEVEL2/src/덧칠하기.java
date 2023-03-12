public class 덧칠하기 {

    /**
     *  TODO
     *   1. 페인터 칠해진 벽 길이 n
     *   2. 벽에 페인트를 다시 칠함
     *   3. 전체 벽이 아닌 구역을 나눠 일부만 칠해 예산을 아낌
     *   4. 1미터 길이를 n 개로 나누고, 왼쪽부터 1~n 번의 번호를 부여
     *   5. 벽에 페인트 칠하는 룰러의 길이는 m
     */

     /** TODO
     *    1. 룰러가 벽에서 벗어나면 안됨
      *   2. 구역의 일부만 포함하도록 칠하면 안됨
      *   => 룰러의 왼쪽 오른쪽 끝에 벽의 끝 부분에 맞닿아 칠함
      **/

    /** TODO
     *      1. section : 페인트를 다시 칠 할 구역의 번호
     *      2. result : 룰러로 페인트 칠 할 최소 횟수
     */
    public static void main(String[] args) {
        int n = 8;
        int m = 4;
        int[] section = {2,3,6};
        int solution = solution(n, m, section);
        System.out.println(solution);
    }

    public static int solution(int n, int m, int[] section) {
        int answer = 0;

        int end = 0;

        for (int i=0; i<section.length; i++) {
            if(section[i] < end) continue;
            answer++;
            end = section[i] + m;
        }

        return answer;
    }
}
