import java.io.*;

public class test6 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] seat = input.split(" ");

        int min = 999999;

        int[] result = new int[2];

        for (int i = 0; i < seat.length; i++) {
            int me = Integer.parseInt(seat[i]);
            for (int j = i + 1; j < seat.length; j++) {
                int you = Integer.parseInt(seat[j]);
                int res = me - you;
                if(res<0) res *= -1;
                if(min>res){
                    result[0] = me;
                    result[1] = you;
                    min = res;
                }
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }
}
