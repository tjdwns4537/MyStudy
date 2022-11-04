import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class 물감구매하기 {
    /*
    - 목표 :
    1) 라이언이 춘식이에게 물감을 사주기
    2) 라이언이 가진 예산 x원으로 얻을 수 있는 최대한 많은 양의 물감 개수를 구해라.

    - 입력 :

    - 조건 :
    1) 물감 가게는 색깔 별로 금액을 받음
    2) n가지 색의 물감을 판매하며, i번째 물감 색깔 가격은 cost[i] 원임
    3) i번째 색깔을 구매하면 2^i개 만큼의 물감을 얻을 수 있음
    4) 얻은 물감 개수가 (10^9 + 7) 개 이상인 경우, 얻은 물감 개수 % (10^9 + 7 ) 개 만큼 반환

    */
    public static void main(String[] args) {
        List<Integer> cost = new ArrayList<>();
        cost.add(3);
        cost.add(4);
        cost.add(1);

        int x = 8;
        int n = 5;
        System.out.println(solution(cost, x));
    }

    public static int solution(List<Integer> cost, int x) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        int compNum = 0;

        for (int i = cost.size() - 1; i >= 0; i--) {
            sum += cost.get(i);
            list.add(i);

            for(int j = i - 1; j >= 0; j--){
                if ((sum+cost.get(j)) <= x) {
                    sum += cost.get(j);
                    list.add(j);
                }
            }

            for (Integer w : list) {
                compNum += (int)Math.pow(2, w);
            }

            if(compNum != 0) break;
        }

        if((Math.pow(10, 9) + 7) < compNum) return (int) (compNum % (Math.pow(10, 9) + 7));
        else return compNum;
    }
}
