public class 미로탈출 {
    /**
     *  TODO
     *      1. 배열에서 S, E 위치 파악
     *      2. S < E : ++, S > E : --
     *      3. visit 체크로 통로가 있는지 확인
     *      4. 통로가 없다면 좌,우 인덱스 비교
     *      => bfs + bfs 활용
     * **/

    static int length;
    static boolean[] visit;
    static int count;

    public static void main(String[] args) {
        String[] maps = {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};
        solution(maps);
    }

    public static int solution(String[] maps) {
        int answer = 0;
        return answer;
    }
}
