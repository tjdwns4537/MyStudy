import java.util.Scanner;

public class test1 {
    /**
     - 문제 :
     1) 0과 1로 이뤄진 필셀
     2) 가로/세로가 동일한 정사각형이고 길이는 2의 제곱수로 표시
     3) 이미지 압축 알고리즘 규칙
      - 모든 필셀이 동일할 때 경과는 0 또는 1로 표시
      - 0 / 1이 섞여 있으면 이미지를 동일한 크기로 4분할 후
        동일한 과정을 수행 후 결과를 ( XXXX ) 형태로 출력
        순서는 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래 순
     **/

    public static int[][] img;		// 흑백 이미지
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();

        img = new int[size][size];

        for (int i = 0; i < size; i++) {
            String str = in.next();
            for (int j = 0; j < size; j++) {
                img[i][j] = str.charAt(j) - '0';
            }
        }

        QuadTree(0, 0, size);
        System.out.println(sb);
    }

    public static void QuadTree(int x, int y, int size) {

        // 압축이 가능할 경우 하나의 색상으로 압축해준다.
        if(isPossible(x, y, size)) {
            sb.append(img[x][y]);
            return;
        }

        int newSize = size / 2;	// 압축이 불가능 할 경우 사이즈를 절반으로 나누어야 한다.

        sb.append('(');	// 각 레벨(depth)에서 여는괄호로 시작해야한다.

        QuadTree(x, y, newSize);						// 왼쪽 위
        QuadTree(x, y + newSize, newSize);				// 오른쪽 위
        QuadTree(x + newSize, y, newSize);				// 왼쪽 아래
        QuadTree(x + newSize, y + newSize, newSize);	// 오른쪽 아래

        sb.append(')');	// 해당 레벨이 끝나면 닫는괄호도 닫아준다.


    }

    // 압축이 가능한지 해당 공간을 체크해주는 함수
    public static boolean isPossible(int x, int y, int size) {
        int value = img[x][y];

        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(value != img[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
