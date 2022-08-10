import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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

    */
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] solution = solution(id_list, report, k);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i] + " ");
        }

    }
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        String[][] comp = new String[][];
        HashMap<String, String> map = new HashMap<>();
        String[][] SplitString = new String[report.length][2];
        int[] cnt = new int[id_list.length];

        for (int i = 0; i < cnt.length; i++) {
            cnt[i] = 0;
        }

        // report 에 (띄어쓰기) 를 기준으로 split 해서 배열에 담음
        // 0번부터 짝수는 신고인, 홀수는 신고 당한사람
        // 신고인과 신고 당한사람 비교 문법 필요
        // k번 이상된 사람 있으면 cnt 의 해당하는 인덱스에 카운터가 증가됨
        for (int i = 0; i < report.length; i++) {
            SplitString[i] = report[i].split(" ");
        }

        for (int i = 0; i < SplitString.length; i++) {
            for (int w = 0; w < id_list.length; w++) {
                Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
                while (entries.hasNext()) {
                    Map.Entry<String, String> entry = entries.next();
                    if (entry.getKey().equals(SplitString[i][0]) && entry.getValue().equals(SplitString[i][1])) {
                        continue;
                    }
                }

                if(SplitString[i][1].equals(id_list[w])){
                    map.put(SplitString[i][0],SplitString[i][1]);
                    cnt[w] = cnt[w]+1;
                }

            }
        }

        for (int i = 0; i< id_list.length; i++) {
            for (int j = 0; j < SplitString[i].length; j++) {
                if(SplitString[i][j].equals(id_list[i])){
                    if(cnt[i] >= k){
                        answer[i] = answer[i]+1;
                    }
                }
            }
        }
        return answer;
    }
}
