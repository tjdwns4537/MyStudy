import java.util.ArrayList;

public class Permutation {
    //순열의 모든 경우를 나열하라
    //반복문 개수 == 요소를 뽑는 개수
    public static void main(String[] args) {
        String[] arr = new String[]{"A","B","C","D","E"};
        ArrayList<String[]> newArr = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    if (i == j || j == k || i == k) {
                        continue;
                    }
                    String[] input = new String[]{
                            arr[i],arr[j],arr[k]
                    };
                    newArr.add(input);
                }
            }
        }
        for (int i = 0; i < newArr.size(); i++) {
            for (int j = 0; j < newArr.get(i).length; j++) {
                System.out.print(newArr.get(i)[j]);
            }
            System.out.println();
        }
    }
}
