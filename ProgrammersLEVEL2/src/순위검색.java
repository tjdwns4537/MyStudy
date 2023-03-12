import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class 순위검색 {

    /**
     *  TODO
     *   1. cpp, java, python 중 하나 선택
     *   2. backend와 frontend 중 하나를 선택
     *   3. junior와 senior 중 하나를 선택
     *   4. chicken과 pizza 중 하나를 선택
     *   질문 :
     *   * [조건]을 만족하는 사람 중 코딩테스트 점수를 X점 이상 받은 사람은 모두 몇 명인가?
     *   ex.
     *   코딩테스트에 java로 참여했으며,
     *   backend 직군을 선택했고,
     *   junior 경력이면서,
     *   소울푸드로 pizza를 선택한 사람 중
     *   코딩테스트 점수를 50점 이상 받은 지원자는 몇 명인가?
     * **/
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        solution(info, query);
    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = {};
        String[] info_data;
        String[] query_data;
        for (String i : info) {
            List<String> collect = Arrays.stream(i.split(" ")).collect(Collectors.toList());
        }

        for (String j : query) {
            List<String> collect = Arrays.stream(j.split(" and ")).collect(Collectors.toList());
            Arrays.stream(collect.get(collect.size()).split(" ")).collect(Collectors.toList());
            String[] s = collect.get(collect.size()).split(" ");
//            collect.add()
            for (String i : collect) {
                System.out.println(i);
            }
        }

//        Arrays.stream(query).filter(m -> Arrays.stream(query).noneMatch(Predicate.isEqual(m)))
//                .toArray();
        return answer;
    }
}
