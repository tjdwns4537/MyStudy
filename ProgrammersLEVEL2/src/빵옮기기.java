import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class 빵옮기기 {

    /*
    - 문제 :
    n개의 상자 배열에 빵을 나눠 담는 방법

    - 조건 :
    1) 2 <= i <= n을 만족하는 i
    2) 1 <= x <= box[i] 를 만족하는 x
    3) i번째 박스에서 x개 만큼의 빵을 꺼냄 ( box[i] = box[i] - x )
    4) i-1번째 박스에서 꺼낸 x 개 만큼의 빵을 넣음 ( box[i-1] = box[i-1] + x )


    모든 상자 중 가장 빵이 많은 상자에 든 빵의 개수가 가장 적어지도록 빵을 옮기는 일
    최종적으로 얻을 수 있는 빵이 가장 많은 상자에 든 최소한의 빵 개수를 구해라.

    */
    public static void main(String[] args) {
        List<Integer> box = new ArrayList<>();
        box.add(5);
        box.add(15);
        box.add(19);
        System.out.println(solution(box));
    }

    public static int solution(List<Integer> box) {
        // Write your code here
        int now = 0;
        int prev = 0;
        int maxNum = 0;
        int minNum = 0;
        int selIndex = 0;
        int selIndex2 = 0;
        int sendNum = 0;
        int aver = 0;

        for(Integer i : box){
            aver += i;
        }
        aver = aver / box.size();

        while(true){
            for (Integer i : box) {
                System.out.print(i + " ");
            }
            System.out.println();

            maxNum = Collections.max(box);
            if(maxNum == aver) break;

            selIndex = box.indexOf(maxNum); // i

            sendNum = maxNum - aver; // x

            now = box.get(selIndex);
            prev = box.get(selIndex - 1);

            box.set(selIndex, now - sendNum);
            box.set(selIndex-1, prev + sendNum);
        }
        return maxNum;
    }
}
