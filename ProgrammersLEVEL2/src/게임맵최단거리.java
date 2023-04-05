import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

    /**
     * TODO
     *  - 두 팀으로 나눠, 상대 팀 진영을 먼저 파괴하면 이기는 게임
     *  - n.m 에서부터 출발한다.
     * **/

    public static void main(String[] args) {
        int[][] arr = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int solution = solution(arr);
        System.out.println(solution);
    }

    public static int solution(int[][] maps) {
        int answer = 0;
        int[][] move ={{0,1},{0,-1},{1,0},{-1,0}};
        Queue<Position> que =new LinkedList();
        int[][] count =new int[maps.length][maps[0].length];

        que.add(new Position(0,0));
        count[0][0]=1;

        while(!que.isEmpty()){
            Position cur =que.poll();
            int curcount = count[cur.y][cur.x];
            for(int i=0;i<4;i++){
                Position p = new Position(cur.x+move[i][0],cur.y+move[i][1]);
                //맵밖으로 나갈때
                if(p.x<0||p.y<0||p.x==maps[0].length||p.y==maps.length){
                    continue;
                }
                //벽에 부딪힐때
                if(maps[p.y][p.x]==0){
                    continue;
                }
                count[p.y][p.x]=curcount+1;
                //이미 지난길은 벽으로 만들어버리기
                maps[p.y][p.x]=0;
                que.add(p);
            }
        }
        answer=count[maps.length-1][maps[0].length-1];
        if(answer==0){
            return -1;
        }
        return answer;
    }
}

class Position{
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
