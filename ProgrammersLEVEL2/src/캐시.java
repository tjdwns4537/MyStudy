import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class 캐시 {

    /**
     - 설명 :
     1. 테스팅 업무는 어피치
     2. 제이지가 작성한 데이터베이스에서 게시물 불러오는 부분의 실행시간이 오래걸림
     3. 어피치는 제이지에게 해당 로직 개선하라고 지시
     4. 제이지는 DB 캐시를 적용하여 성능 개선을 시도하지만 효율적인 캐시 크기를 몰라 난감

     - 입력 형식 :
     캐시 크기 ( cacheSize ), 도시 이름 배열 ( cities )

     - 입력 조건 :
     공백, 숫자, 특수문자 등이 없는 영문자
     대소문자 구분안함
     최대 20자

     - 조건 :
     캐시 교체 알고리즘 > LRU 사용
     cache hit일 경우 실행 시간은 1
     cache miss일 경우 실행 시간은 5

     - 용어 설명 :
     1) 캐시 히트 = 캐시 메모리에 찾는 데이터가 존재했을 때
     2) 캐시 미스 = 캐시 메모리에 찾는 데이터가 존재하지 않았을 때
     **/

    public static void main(String[] args) {
        int cache = 3;
        int cache2 = 0;
        int cache3 = 2;
        String[] cities = {
                "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"
        };
        String[] cities2 = {
                "Jeju", "Pangyo", "Seoul", "NewYork", "LA"
        };
        String[] cities3 = {
                "Jeju", "Pangyo", "NewYork", "newyork"
        };
        System.out.println(solution(cache3, cities3));
    }


    public static int solution(int cacheSize, String[] cities) {
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase(Locale.ROOT);
        }
        int answer = LRU(cacheSize, cities);
        return answer;
    }

    public static int LRU(int s, String[] cities){
        List<String> temp = new ArrayList<>();
        int excuteTime = 0;
        int cnt = 0;
        boolean check = false;

        while (cnt < cities.length) {
            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i).equals(cities[cnt])) {
                    excuteTime += 1;
                    temp.remove(temp.get(i));
                    temp.add(0, cities[cnt]);
                    check = true;
                    break;
                }
            }

            if (!check){
                temp.add(0, cities[cnt]);
                excuteTime += 5;
            }

            if (temp.size() > s) {
                temp.remove(temp.size() - 1);
            }

            cnt++;
            check = false;
        }

        excuteTime += (s - temp.size());

        return excuteTime;
    }
}
