import java.util.ArrayList;

public class Combination {

    public static void main(String[] args) {

        String[] strArr = new String[]{
                "A","B","C","D","E"
        };

        ArrayList<String[]> result = new ArrayList<>();

        for (int i = 0; i < strArr.length; i++) {
            for (int j = i+1; j < strArr.length; j++) {
                for (int k = j + 1; k < strArr.length; k++) {
                    String[] input=new String[]{
                            strArr[i],strArr[j],strArr[k]
                    };
                    result.add(input);
                }
            }
        }

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).length; j++) {
                System.out.print(result.get(i)[j]);
            }
            System.out.println();
        }
    }
}
