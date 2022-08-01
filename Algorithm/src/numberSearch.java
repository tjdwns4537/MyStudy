public class numberSearch {
    public static void main(String[] args) {
        int result = 0;
        double sum = 0.0;
        String str = "Hello6 9World 2, Nic8e D7ay!";
        String temp = "";

        if(str.length() == 0) System.out.println(0);

        for(int i=0; i<str.length(); i++){
            if(Character.isDigit(str.charAt(i))){
                sum += Character.getNumericValue(str.charAt(i));
            }
            else if(str.charAt(i) == ' ') continue;
            else{
                temp += str.charAt(i);
            }
        }
        result =  (int) Math.round(sum/(temp.length()));
    }
}
