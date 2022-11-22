import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class test3 {
    /**
     - 문제 :
     1) 말판의 N개
     2) 칸 번호는 0 ~ N-1
     3) 시작 : 0
     4) 정육면체 주사위를 굴려 나오는 숫자만 큼 이동 ( 0 ~ 6 )
     5) 일부 칸에 점프 기능 포함 ( 점프는 앞,뒤로 이동 가능 )

     - 종료 :
     1) 마지막 칸에 도착하거나 통과되면 승리 ( 주사위 횟수 출력 )
     2) 무한 반복 구간에 들어가면 강제로 게임 종료 ( -1 출력 )

     - 입력 :
     1) 게임 칸 개수, 점프 칸 개수 입력
     2) 점프 칸 번호, 이동 칸 번호 입력
     3) 점프 칸 개수 만큼 반복

     **/
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputArr = input.split(" ");

        int moveCnt = Integer.parseInt(inputArr[0]);
        int jumpCnt = Integer.parseInt(inputArr[1]);

        List<Integer> jumpArr = new ArrayList<>();

        for (int i = 0; i < jumpCnt; i++) {
            input = br.readLine();
            inputArr = input.split(" ");
            jumpArr.add(Integer.parseInt(inputArr[0]));
            jumpArr.add(Integer.parseInt(inputArr[1]));
        }

        int move = 0;
        int rand = 6;
        int resultCnt = 0;
        int maxMove = 0;

        while(move < moveCnt-1){
            boolean Jump = false;
            for (int i = 0; i < jumpArr.size(); i += 2) {
                if (move+rand >= jumpArr.get(i)) { // 점프로 이동
                    maxMove = Math.max(move+rand, jumpArr.get(i + 1));
                    Jump = true;
                }
            }

            if(!Jump) move += rand;
            else move = maxMove;
            resultCnt++;
        }

        System.out.println(resultCnt);
    }

}
