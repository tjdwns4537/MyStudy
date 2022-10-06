public class TargetNumber {

    /**
     1. 문제
     - n개의 음이 아닌 정수들 존재
     - 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟넘버 만들기
     - [ 1,1,1,1 ] 로 숫자3 을 만드는 방법을
        ( -1+1+1+1+1 = 3 )
        ( +1-1+1+1+1 = 3 ) ...
     **/

    static int answer = 0;
    static int[] numbers;
    static int target;

    public static void main(String[] args) {
        int[] numbers1 = {1, 1, 1, 1, 1};
        int[] numbers2 = {4,1,2,1};

        solution(numbers1, 3);
        System.out.println(answer);
    }

    public static int solution(int[] _numbers, int _target) {
        answer = 0;
        numbers = _numbers;
        target = _target;

        dfs(0,0);

        return answer;
    }

    public static void dfs(int index, int sum) {

        // 1. 탈출 방법
        if (index == numbers.length) { // 인덱스가 배열 길이가 될 때
            if(sum == target){ // 합이 타겟이 될 때
                answer++;
                return;
            }
        }

        // 2. 구현 동작
        try{
            // 덧셈을 수행
            dfs(index + 1, sum + numbers[index]);
            // 뺄셈을 수행
            dfs(index + 1, sum - numbers[index]);
        } catch (Exception e){

        }

    }
}
