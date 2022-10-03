import java.util.*;

public class TripCourse {
    /**
     * - 문제
     * 방문하는 공항 경로를 배열에 담아 출력

     * - 조건
     * 1) 주어진 항공권을 모두 이용해 여행경로를 구성
     * 2) 항상 ICN 공항에서 출발
     **/

    private static boolean[] visit;
    private static ArrayList<String> allRoute;

    public static void main(String[] args) {
        String[][] tickets = {
                {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}
                ,{"ATL","ICN"},{"ATL","SFO"}};

        String[][] tickets2 = {
                {"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}
                };

        String res = Arrays.toString(solution(tickets));
        System.out.println(res);
    }

    public static String[] solution(String[][] tickets) {
        String[] answer = {};
        int cnt = 0;
        visit = new boolean[tickets.length];
        allRoute = new ArrayList<>();

        dfs("ICN", "ICN", tickets, cnt);

        Collections.sort(allRoute);
        answer = allRoute.get(0).split(" ");

        return answer;

    }

    public static void dfs(String start, String route, String[][] tickets, int cnt) {
        if (cnt == tickets.length) {
            allRoute.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (start.equals(tickets[i][0]) && !visit[i]) {
                visit[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt+1);
                visit[i] = false;
            }
        }
    }
}
