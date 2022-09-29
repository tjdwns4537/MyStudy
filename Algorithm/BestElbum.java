import java.util.*;

public class BestElbum {

    /**
     - 목표
     베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 출력

     - 노래를 수록하는 기준
     1) 속한 노래가 많이 재생된 장르를 먼저 수록
     2) 장르 내에서 많이 재생된 노래를 먼저 수록
     3) 장르 내에서 재생 횟수가 같은 노래중에서 고유 번호가 낮은 노래를 먼저 수록

     - 배열 설명
     1) genres : 노래의 장르를 나타냄
     2) plays : 노래별 재생횟수를 나타냄

     - 해결과정
     1) play 횟수를 중첩해서 더해준다.
     2) 키 값만을 추출하여 리스트를 만들고, 리스트를 play횟수를 기준으로 정렬한다.
        ( 그 이유는 hashMap 은 순서가 없기 때문에 정렬할 수 없기 때문이다. )
     3) key값을 정렬한 리스트에서 제일 많은 횟수를 재생한 장르부터 장르별 제일 많은 횟수가 플레이된 인덱스,
        두번째로 많은 횟수가 플레이된 인덱스를 찾아 정답 배열에 순서대로 넣어준다.
     4) 이때, 두번째로 많은 횟수가 플레이된 인덱스는 존재하지 않을 수 있기 때문에 이를 처리
     5) 정답 리스트를 배열로 변환하여 반환

   */

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        String resultArr = Arrays.toString(solution(genres, plays));
        System.out.println(resultArr);
    }



    public static int[] solution(String[] genres, int[] plays) {
        ArrayList<String> genre = new ArrayList<>();
        Map<String, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        // 키 값이 이미 있으면 0을 반환하고 중첩되는 부분이 있으면 더해준다.
        for (int i = 0; i < genres.length; i++) {
            hashMap.put(genres[i], hashMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        for (String key : hashMap.keySet()) {
            genre.add(key);
        }

        Collections.sort(genre, (o1, o2) -> hashMap.get(o2) - hashMap.get(o1));
        // key 값을 더해준 hashMap 에 대한 값을 내림차순으로 정렬한다.

        for (int i = 0; i < genre.size(); i++) {
            String g = genre.get(i); // 내림차순 정렬된 장르 리스트를 조회

            int max = 0; // 장르의 음악에서 재생 횟수가 가장 큰 인덱스를 찾는다.
            int firstIdx = -1;
            for (int j = 0; j < genres.length; j++) { // 기존의 장르 배열만큼 반복
                if(g.equals(genres[j]) && max < plays[j]){
                    // 장르 명이 동일하면 그 장르의 인덱스를 뽑아준다.
                    max = plays[j];
                    firstIdx = j;
                }
            }

            max = 0;
            int secondIdx = -1;
            for (int j = 0; j < genres.length; j++) {
                if (g.equals(genres[j]) && max < plays[j] && j != firstIdx) {
                    max = plays[j];
                    secondIdx = j;
                }
            }

            list.add(firstIdx);
            if (secondIdx >= 0) { // 장르에 대한 곡이 하나밖에 없는 경우는 -1로 남음
                list.add(secondIdx);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
