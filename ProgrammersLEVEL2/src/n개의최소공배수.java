public class n개의최소공배수 {
    /*
    - 배열의 공배수가 되는 가장 작은 숫자를 구해라

    [ 해결과정 ]
    - 유클리드 호제법 알고리즘으로 최소 공배수/최대 공약수를 구한다.
    - 여기서 구한 최소 공배수를 다음 배열에 반복
     */
    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 14};
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr) {
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int gcd = gcd(answer, arr[i]); // 최대 공약수
            answer = answer * arr[i] / gcd; // 최소 공배수
        }

        return answer;
    }

    public static int gcd(int a,int b){
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        while(max % min != 0){
            int r = max % min;
            max = min;
            min = r;
        }
        return min;
    }
}
