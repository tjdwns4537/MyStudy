public class wordChange {

    /**
     - 문제
     begin 에서 target 으로 변환하는 가장 짧은 변환 과정을 찾아라

     - 조건
     1) 한 번에 한 개의 알파벳만 바꿀 수 있음
     2) words 에 있는 단어로만 변환할 수 있음

     - 알고리즘
     dfs

     - 해결 과정
     1) 한 글자 빼고 나머지가 같은 단어를 words 에서 찾는다.
     2) 찾은 단어를 visited = true 로 설정
     3) cnt 를 증가시키며 dfs 함수를 재귀 호출
     4) 모든 경우의 수를 보기 위해 check = false 로 재설정
     5) begin 과 target이 같은 경우 cnt를 answer에 대입하고 종료

     **/

    static boolean[] check;
    static int answer = 0;

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        answer = solution(begin, target, words);
        System.out.println(answer);

    }

    public static int solution(String begin, String target, String[] words) {
        check = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }

    public static void dfs(String begin, String target,String[] word, int cnt) {

        if (begin.equals(target)) { // 타겟과 시작 단어가 같으면 바로 리턴
            answer = cnt; // 두 글자 빼고 같은 경우 0 -> 1 -> 2로 증가함
            return;
        }

        for (int i = 0; i < word.length; i++) {
            int k = 0; // 같은 스펠링이 몇개인지 세기 위한 변수
            if(check[i]){ // 한번 지나간 단어는 패스
                continue;
            }
            for (int j = 0; j < begin.length(); j++) {
                if(begin.charAt(j) == word[i].charAt(j)){
                    // begin 과 word 의 각 단어 내부를 확인
                    /*
                    ex. hit, dog, ["hot", "dot", "dog", "lot", "log", "cog"] 일 때,
                    begin : hit
                    word[0] : hot
                    k : 2
                     */
                    k++;
                }
            }

            /*
            ex. k = 2 이므로,
            check[0] = true;
            dfs ( hot, cog, word, 1 );
            check[0] = false;

             */
            if (k == begin.length() - 1) { // 한글자 빼고 두 같은 경우만 보면 됨
                check[i] = true; // 지나간 자리는 true
                dfs(word[i], target, word, cnt + 1);
                check[i] = false;
            }
        }
    }


}
