public class 상자놀이 {

    /*
    - 목표:
    춘식이가 놀이를 진행하며 도착할 수 있는 k번째 상자 중 가능한 k의 최대값을 구해라

    - 입력:
    정수 x,y,z

    - 과정:
         춘식 : 왼쪽에서 x번째 상자 놀이 시작해서 매 턴마다 오른쪽이나 왼쪽으로 한 칸씩 이동하여 y칸에 도착

    - 주의사항:
    1) 놀이 진행하는 동안 z번의 이동이 가능하며 모든 방향은 동일할 수 있음
    2) x,y 의 차가 1이면 0인거와 같음
    3) x>y , x<y 인 경우의 수가 잇음
    */

    public static void main(String[] args) {
        System.out.println(solution(4,4,4));
    }

    public static int solution(int x, int y, int z) {
        // Write your code here
        if ( (y - x) > z) return -1;
        if(x<y) return (((z - (y - x)) / 2) + y);
        else if (x>y) return (((z - (x - y)) / 2) + x);
        else if ( x == y ) return ( y + (z / 2));

        return -1;
    }
}
