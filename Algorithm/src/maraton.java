import static java.util.Arrays.sort;

public class maraton {

    /**
     - 문제
        마라톤 선수 이름이 담긴 배열 participant
        완주한 선수 이름이 담긴 배열 completion
        완주하지 못한 선수의 이름을 return 하는 함수 작성

     - 제한 사항
        1) 참여자수 : 1~100,000
        2) completion == participant + 1
        3) 참가자 이름
            - 알파벳 소문자 20글자 이하
            - 동명이인 있을 수 있음
     **/


    public static void main(String[] args) {
        String returnMember;
        String returnMember2;

        String[] participantInput = {"leo", "kiki", "eden"};
        String[] participantInput2 = {"mislav", "stanko", "mislav", "ana"};
        String[] completionInput = {"eden", "kiki"};
        String[] completionInput2 = {"stanko", "ana", "mislav"};
        returnMember = calMember(participantInput, completionInput);
        returnMember2 = calMember(participantInput2, completionInput2);
        System.out.println(returnMember);
        System.out.println(returnMember2);
    }

    public static String calMember(String[] participant,String[] completion) {
        String result = "";

        sort(participant);
        sort(completion);

        for (int i = 0; i < participant.length-1; i++) {
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }

        result = participant[participant.length-1];

        return result;
    }
}
