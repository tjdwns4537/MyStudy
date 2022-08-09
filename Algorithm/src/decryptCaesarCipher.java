public class decryptCaesarCipher {
    public static void main(String[] args) {
        String res = decryptCaesarCipher("nzop delepd dfaazced jzf", 11);
        System.out.println(res);
    }

    public static String decryptCaesarCipher(String str, int secret) {
        // TODO:
        /*
        - when : 암호화된 문자열과 암호화된 키를 입력받음
        - then : 복호화된 문자열을 리턴
        - how : 카이사르 암호는 평문을 암호키개만큼 오른쪽으로 평행이동시켜 암호화한다.
         */
        String result = "";
        int temp = 0;
        int overNum = 0;
        //when
        char[] ch = str.toCharArray();

        //how
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] == ' '){
                result += ch[i];
            }
            else{
                if(ch[i]-secret >= 97) temp = ch[i]-secret;
                else{
                    overNum = 96 - (ch[i] - secret);
                    temp = 122 - overNum;
                }
                System.out.println("i: "+i+" "+ "temp: "+temp);
                result += Character.toString((char)temp);
            }
        }

        //then
        return result;
    }
}
