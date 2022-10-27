import java.util.*;

public class 최솟값만들기 {

    /**
     - 문제 설명:
     두 배열 각각에서 하나의 숫자를 뽑아 두 수를 곱합니다.
     이러한 과정에서 배열의 길이만큼 반복하여 두 수를 곱한 값을 누적하여 더합니다.
     이때 최종적으로 누적된 값이 최소가 되는게 목표입니다.

     - 조건 :
     각 배열에서 k번째 숫자를 뽑았다면 다음에 k번째 숫자를 다시 뽑을 수 없음

     - 해결 과정 :
     1) 예를 들어, [ 1*2+3*3= 11 ], [ 1*3+3*2 = 9 ] 이와 같이 가장 큰 수에 가장 작은 수를 곱해줘야 합니다.
     2) 그래서 두 배열 각각을 오름차순, 내림차순으로 정렬한다.
     3) 곱을 누적시킨다.
     **/

    public static void main(String[] args) {
        int[] A = {1,2};
        int[] B = {3,4};
        System.out.println(solution(A,B));
    }

    public static int solution(int []A, int []B)
    {
        int answer = 0;
        Integer[] Bin = new Integer[B.length];
        Arrays.sort(A);

        for (int i = 0; i < B.length; i++) {
            Bin[i] =Integer.valueOf(B[i]);
        }

        Arrays.sort(Bin,Collections.reverseOrder());

        for (int i = 0; i < B.length; i++) {
            answer += A[i] * Bin[i];
        }

        return answer;
    }
}
