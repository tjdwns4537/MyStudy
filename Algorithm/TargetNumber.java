public class TargetNumber {

    /**
     1. 문제
     - n개의 음이 아닌 정수들 존재
     - 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟넘버 만들기
     - [ 1,1,1,1 ] 로 숫자3 을 만드는 방법을
        ( -1+1+1+1+1 = 3 )
        ( +1-1+1+1+1 = 3 ) ...
     **/

    boolean[] visit;

    public static void main(String[] args) {
        int[] numbers1 = {1, 1, 1, 1, 1};
        int[] numbers2 = {4,1,2,1};
        int target1 = 3;
        int target2 = 4;
    }

    public int solution(int[] numbers, int target) {
        int answer = 0;




        return answer;
    }

    public void dfs(int[] numbers, int target,int sum, int cnt) {
        visit = new boolean[numbers.length];
        visit[target] = true;
        while (sum > target) {

        }
    }
}
