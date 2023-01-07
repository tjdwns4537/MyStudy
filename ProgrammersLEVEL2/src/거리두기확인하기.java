public class 거리두기확인하기 {

    /**
     * 1. 대기실 : 5개 ( 5*5 )
     * 2. 맨해튼 거리 2개 이하 앉기 금지
     * 3. 응시자 사이 파티션이 있다면 앉기 가능
     * [ 입력 값 ]
     * - P : 응시자 앉은 자리
     * - O : 빈 테이블
     * - X : 파티션
     * [ 출력 값 ]
     * - 1 : 통과
     * - 0 : 실패
     **/

    static boolean[] visisted = new boolean[5];

    public static void main(String[] args) {

    }

    public int[] solution(String[][] places) {
        int[] answer = {};

        for (int i = 0; i < places.length; i++) {
            dfs(places[i],i);
        }

        return answer;
    }

    public void dfs(String[] places, int nodeIndex) {
        int Acnt = 0; // P 비교대상
        int Bcnt = 0; // Acnt의 비교대상

        for (String node:places){
            for (int i = 0; i < node.length(); i++) {
                if(node.charAt(i) == 'P'){

                    if(!visisted[i]){
                        Acnt = i;
                        visisted[i] = true;
                    }
                    else{
                        Bcnt = i;
                    }

                }
            }
        }

    }
}
