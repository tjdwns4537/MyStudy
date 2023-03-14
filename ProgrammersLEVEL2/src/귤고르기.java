import java.util.*;
import java.util.stream.Collectors;

public class 귤고르기 {

    /**
     * TODO
     *  1. 정렬시킨다.
     *  2. 정렬 시킨 배열을 같은 수가 있는지 비교한다.
     *  3. 중복되는 수가 가장 많은 크기부터 카운팅을 더한다.
     *  3. k/2 와 카운팅 변수 비교
     * **/

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2, 2, 2, 3};
        int solution = solution(2, arr);
        System.out.println(solution);
    }

    public static int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());

        list.sort((a, b) -> {
            if (map.get(a) < map.get(b)) return 1;
            else if (map.get(a) > map.get(b)) return -1;
            return 0;
        });

        int i = 0;
        while (k > 0) {
            k -= map.get(list.get(i));
            answer++;
            i++;
        }

        return answer;
    }

    public int compare(int a, int b) {
        if(a > b) return 1;
        if(a < b) return -1;
        return 0;
    }
}
