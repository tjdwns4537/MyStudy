public class PrimeProblem {

    /**
     - 문제
     주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우를 구해라

     **/

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 2, 7, 6, 4};
        int solution = solution(nums2);
        System.out.println(solution);
    }
    
    public static int solution(int[] nums) {
        int answer = 0;

        int sum =0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    if(primeNumber(sum)){
                        answer++;
                    }
                }
            }
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }

    public static boolean primeNumber(int n) {
        for (int i = 2; i < n; i++) {
            if(n%i==0) return false;
        }
        return true;
    }
}
