import java.util.*;

public class kakaoMobility_task1 {

    /*
        입력
        - 신입사원 이름 목록 ( 각 신입사원 회사 이메일 주소를 생성해야함 )

        이름 특징
        1) 공백으로 구분된 '이름','중간이름','성' 으로 두가지 또는 세가지 조합으로 구성
        2) 각 부분은 영어 대소문자로만 구성 ( 단, 성에는 _가 들어갈 수 있음 )
        3) 회사 이름도 영문으로만 구성

        주소 형식
        1) 이름중간이름성@Company.com
         ( 단, 중간이름이 있는 경우에만 해당 )
         ( 단, 성은 최대 8개의 이니셜 문자 )
         ( 컴퍼니는 회사이름 )
        2) 주소는 소문자이며 하이픈 포함 안됨 ( 성을 자르기 전에 하이픈 제거 )
        3) 두 명 이상의 사람이 동일한 이메일 사용하는 경우 @ 앞에 숫자를 추가하여 주소를 구분

        String S
        1) 쉼표(,) 다음에 공백인 문자로 구성된 이름 리스트 문자열 S
        2) 회사 이름인 문자열 C가 함수 피라미터로 제공됨
        3) 반환 값으로는 입력돠 동일한 순서로 ", " 문자로 구분된 "이름<이메일>" 형식의 리스트 스트링 반환

         */

    public static void main(String[] args) {
        String S = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
        String C = "example";
        String res = solution(S, C);
        System.out.println(res);
    }

    public static String solution(String S, String C) {
        // write your code in Java SE 8
        String result = "";
        String name = "";
        String EmailFirname = "";
        ArrayList<String> temp = new ArrayList<>();
        ArrayList<Integer> st = new ArrayList<>();

        int cnt = 0;
        try{
            while(true){
                if(cnt != 0){
                    result += ", ";
                }
                name = S.split(",")[cnt++].trim();
                if(name.split(" ").length == 3){
                    char[] ch = name.toCharArray();
                    for (int i = 0; i < name.length(); i++) {
                        if(ch[i] == ' '){
                            st.add(i+1);
                        }
                    }
                    String tempSt = name.split(" ")[2];
                    if(tempSt.split("-").length == 2){
                        tempSt = tempSt.substring(0, 9);
                        EmailFirname = name.substring(0, 1) +  name.substring(st.get(0),st.get(0)+1)+ tempSt.split("-")[0]+ tempSt.split("-")[1];
                    }
                    else{
                        EmailFirname = name.substring(0, 1) + name.substring(st.get(0), st.get(0) + 1) + name.split(" ")[2].substring(0,9);
                    }
                }
                else{
                    EmailFirname = name.substring(0, 1) + name.split(" ")[1];
                }
                temp.add(EmailFirname);
                int frequency = Collections.frequency(temp, EmailFirname);

                if(frequency > 1){
                    EmailFirname = (EmailFirname + frequency);
                }
                result += name + " <" + EmailFirname.toLowerCase(Locale.ROOT) + "@" + C.toLowerCase(Locale.ROOT) + ".com>";
            }
        } catch(Exception e){
        }

        return result;
    }
}
