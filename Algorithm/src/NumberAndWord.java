import java.util.HashMap;
import java.util.Map;

public class NumberAndWord {
    public static void main(String[] args) {
        /*
        - 숫자놀이
        : 네오 -> 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면
        프로도는 원래 숫자를 찾는 게임

        //when
        네오가 프로도에게 일부 자릿수를 영단어로 바꾼 카드를 건네줌

        //then
        프로도는 원래 숫자를 찾음

        // how
        1. hashMap 에 0 ~ 9 까지 저장
        2. 입력받은 문자열을 char 형으로 변환
        3. 변환된 char 형이 문자일 경우 하나씩 합치면서 hash value 값과 동일한지 비교
         ( 숫자일 경우 결과 값에 바로 합쳐줌 )
        4. 비교 후 같으면 해당 값을 hashMap 가 비교해서 같은 값을 가지는 key 값을
           결과 값에 합쳐줌
        */
        int res = solution("one4seveneight");
        System.out.println(res);
    }

    public static int solution(String s){
        int answer = 0;
        String temp = "";


        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(0, "zero");
        hashMap.put(1, "one");
        hashMap.put(2, "two");
        hashMap.put(3, "three");
        hashMap.put(4, "four");
        hashMap.put(5, "five");
        hashMap.put(6, "six");
        hashMap.put(7, "seven");
        hashMap.put(8, "eight");
        hashMap.put(9, "nine");

        //when
        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            int k = Character.getNumericValue(ch[i]);
            if(0 <= k && k <= 9){
                if(answer == 0){
                    answer += k;
                }
                else{
                    answer = (answer * 10) + k;
                }
            }
            else {
                temp += ch[i];
                for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
                    if (entry.getValue().equals(temp)) {
                        if (answer == 0) {
                            answer += entry.getKey();
                        } else {
                            answer = (answer * 10) + entry.getKey();
                        }
                        temp = "";
                    }
                }
            }
        }

        return answer;
    }
}
