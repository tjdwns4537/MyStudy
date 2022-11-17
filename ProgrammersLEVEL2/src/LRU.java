import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LRU {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int n = kb.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(kb.nextInt());
        }
        myLRU(s, arr);
    }

    public static void myLRU(int s, List<Integer> arr) {
        List<Integer> temp = new ArrayList<>();
        int cnt = 0;
        boolean check = false;

        while (cnt < arr.size()) {
            // 이미 숫자가 있는지 확인
            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i) == arr.get(cnt)) {
                    temp.remove(i);
                    temp.add(0,arr.get(cnt));
                    check = true;
                    break;
                }
            }
            if(!check){
                temp.add(0,arr.get(cnt));
            }
            // 최대 크기를 넘은 경우
            if(temp.size() > s){
                temp.remove(temp.size() - 1);
            }
            cnt++;
            check = false;
        }

        for (Integer i : temp) {
            System.out.print(i + " ");
        }
    }
}
