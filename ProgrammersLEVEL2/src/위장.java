import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 위장 {

    /**
     * TODO
     *  - 목표 : 서로 다른 경우의 수를 구해라
     *  - hashMap 을 활용해 배열 두 번째 요소에 대해 같은 값을 카운팅
     *  - 경우의 수 공식을 이용
     *  ex. (상의를 입는 경우의 수 + 해당 옷만 선택하는 경우의 수) * ( 하의를 입는 경우의 수 + 해당 옷만 선택하는 경우의 수 ) - ( 아무것도 입지 않는 경우의 수 )
     * **/

    public static void main(String[] args) {
        String[][] arr = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(arr));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        for(String i : map.keySet()){
            answer *= map.get(i)+1;
        }

        answer -= 1;

        return answer;
    }
}
