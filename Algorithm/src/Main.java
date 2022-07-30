import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int cnt = 0;
        int sum = 0;

        int[] type = {10,20,50};
        int target = 50;

        ArrayList<Integer> sumArr = new ArrayList<>();

        for(int i=0; i<type.length; i++){
            for(int j=i+1; j<type.length; j++){
                sum = type[i] + type[j];
                if(sum == target){
                    for(int k:sumArr){
                        if(sum != k){
                            sumArr.add(sum);
                            cnt++;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
