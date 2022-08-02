import java.util.ArrayList;

public class RockScissorPaper {
    public static void main(String[] args) {
        rockPaperScissors(5);
    }

    public static ArrayList<String[]> rockPaperScissors(int rounds) {
        // TODO:
		/*
		- 2인 이상의 사람
		- "가위,바위,보" -> 매 라운드마다 세 번을 선택할 수 있음
		- 라운트만큼 선택으로 가능한 모든 경우의 수
		- result 가 담는 배열 = 전체 경우의 수 중 한가지 경우
		- rock, paper, scissors 순으로 가중치가 높고 정렬됨
		*/
        int cnn = 0;
        ArrayList<String[]> res = pin(0,rounds,cnn);

        return res;
    }

    public static ArrayList<String[]> pin (int cnt,int round,int cnn){
        String[] result = new String[round];
        String[] input = new String[]{
                "rock","paper","scissors"
        };
        ArrayList<String[]> res = new ArrayList<>();

        if(cnt == round) {
            res.add(result);
            cnn++;
            System.out.println("res:"+res.get(0)[0]);
            System.out.println("cnn:"+cnn);
            return res;
        }
        else{
            for(int i=0; i<input.length; i++){
                result[cnt] = input[i];
                cnn++;
                pin(cnt+1,round,cnn);
            }
        }
        return res;
    }
}
