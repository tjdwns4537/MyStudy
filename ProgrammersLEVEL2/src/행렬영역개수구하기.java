import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class 행렬영역개수구하기 {
    /**
     - 해결 방법 :
     해당 위치에 1이 왔을 때, 왼쪽/왼쪽위/위 가 0이면 add 하고 카운트를 초기화
     **/
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(br.readLine());
        int[][] area = new int[lines][lines];
        for(int i=0; i<lines; i++){
            br.readLine();
        }
        영역구하기(area,0,0);
    }

    public static void 영역구하기(int[][] area,int start,int cnt) {
        List<Integer> count = new ArrayList<>();
        Boolean[] visit = new Boolean[area.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < area.length; i++) {
            if(area[start][i] == 1){
                cnt++;
                if(area[i+1][i] == 1)
                영역구하기(area, i + 1, cnt);
            }
            else {

            }
        }



        count.add(cnt);
        Collections.sort(count);
        System.out.println(count.size());
        for (Integer i : count) {
            System.out.print(i + " ");
        }
    }


}
