import java.util.Arrays;

public class 전화번호목록 {

    /**
     * TODO
     *  - 접두사 찾기
     *  - Arrays.sort 로 길이순 정렬
     *  - Arrays's startWith method 로 접두사 확인
     * **/

    public static void main(String[] args) {
        String[] arr = {"12", "123", "1235", "567", "88"};
        boolean solution = solution(arr);
        System.out.println(solution);
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length-1; i++) {
            String prev = phone_book[i];
            if(phone_book[i + 1].startsWith(prev)) return false;
        }

        return answer;
    }
}
