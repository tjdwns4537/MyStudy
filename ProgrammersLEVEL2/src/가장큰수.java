import java.util.*;

public class 가장큰수 {

    /**
     *  TODO
     *      - 문제: 주어진 정수에서 가장 큰 수를 만들어라
     *      - 정수 배열을 문자 배열로 변환
     *      - Comparator 을 활용해 내림차 순 정렬
     *      - compareTo 의 아스키 코드 값 비교를 이용
     * **/

    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};
        String solution = solution(arr);
        System.out.println(solution);

    }

    public static String solution(int[] numbers) {
        String answer = "";

        String[] arr = new String[numbers.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, new Comparator<String>() { // 내림차순 정렬
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if(arr[0].equals("0")) return "0";

        for (String i : arr) {
            answer += i;
        }

        return answer;
    }
}
