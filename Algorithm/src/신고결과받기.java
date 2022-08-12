import java.lang.reflect.Array;
import java.util.*;

public class 신고결과받기 {
    /*
    - 문제 : 불량 이용자 신고 후 처리 결과를 메일로 발송하는 시스템 개발
    - 시스템 :
    1) 각 유저는 한 번에 한명의 유저 신고 가능
     + 신고 횟수 제한 없음
     + 서로 다른 유저 계속 신고 가능
     + 한 유저를 여러본 신고할 수 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됨

    2) k번 이상 신고된 유저는 게시판 이용 금지되며,
    그 유저에 대해 모든 유저에게 정지 사실 메일로 발송됨
     + 유저가 신고한 모든 내용을 취합해서 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송

    - 입력 값 :
    id_list : 유저 목록
    report : 신고 한 사람과 신고 당한 사람
    k : 정지되는 횟수

    - 신고 메일 양식 :
    "muzi"가 "frodo"를 신고했습니다.

    - 유저 목록 :
    "muzi", "frodo", "apeach", "neo"

    - 결과 :
    각 유저별 메일을 받은 횟수를 배열에 담은 것을 리턴

        // report 에 (띄어쓰기) 를 기준으로 split 해서 배열에 담음
        // 0번부터 짝수는 신고인, 홀수는 신고 당한사람
        // 신고인과 신고 당한사람 비교 문법 필요
        // k번 이상된 사람 있으면 cnt 의 해당하는 인덱스에 카운터가 증가됨

    */
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 2;
        int[] solution = solution(id_list, report, k);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i] + " ");
        }

    }

    public static int[] solution(String[] id_list, String[] report, int k){
        int[] answer = new int[id_list.length];

        /*
        HashMap<String,HashSet<String>> DeclaratedMap
        -> 중복 체크

        HashMap<String,Integer> DeclarateMap
        -> 키값 : 신고당한사람, value값 : 카운트 횟수

        HashSet<String> repSet
        -> report 를 리스트로 변환한 후 hashSet 의 요소로 넣어줌
         */

        HashMap<String, HashSet<String>> DeclaratedMap = new HashMap<>();
        HashMap<String, Integer> DeclarateCountMap = new HashMap<>();
        HashSet<String> DeclarateSet = new HashSet<>(Arrays.asList(report));

        for (String DeclareInfo : DeclarateSet) {
            String Declarater = DeclareInfo.split(" ")[0];
            String Declarated = DeclareInfo.split(" ")[1];

            // HashSet 에 신고 당한 대상을 담아준다.
            HashSet<String> temp = new HashSet<>();
            temp.add(Declarated);

            // 만약 신고 당한 대상의 map에 신고 한 사람 이름의 키 값이 존재 하지 않으면 추가해준다.
            DeclaratedMap.putIfAbsent(Declarater, temp);

            // 신고 당한 대상의 map 에 신고한 사람의 키에 대한 HashSet에 신고당한 대상의 이름을 넣어준다.
            DeclaratedMap.get(Declarater).add(Declarated);

            DeclarateCountMap.put(Declarated, DeclarateCountMap.getOrDefault(Declarated, 0) + 1);
        }

        //
        for (String Declared : DeclarateCountMap.keySet()) {
            int DeclaredCount = DeclarateCountMap.get(Declared);
            if (DeclaredCount >= k) {
                for (int i = 0; i < id_list.length; i++) {
                    if (DeclaratedMap.containsKey(id_list[i]) && DeclaratedMap.get(id_list[i]).contains(Declared)) {
                        answer[i]++;
                    }
                }
            }
        }

        return answer;
    }
}
