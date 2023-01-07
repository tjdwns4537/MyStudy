public class naver1 {
    /**
    [ 문제 ]
     - 연간 납부금액 : 이번달 포함 12개월간 납부금액의 총합
     - 이번달 VIP 아니지만, 다음 달 VIP 가 되는 고객
     - 이번달 VIP 지만, 다음 달 VIP 아니게 되는 고객
     - 두 고객에게 알림을 보내야함

     > period : 고객의 가입기간
     > payments : 고객의 납부 내역
     > estimates : 고객의 납부 예정 금액
     > period,payments,estimates length equals

     > period[i] = i+1 번 고객의 가입 기간이 몇개월인지
     > payments[i][j] = i+1 번 고객이 11-j 달 이전에 납부한 금액
     ex. payments[i][11] = i+1 번 고객이 이번 달에 납부한 금액
     > estimates[i] = i+1 번 고객이 다음 달에 납부할 납부 예정 금액


     */
    public static void main(String[] args) {

    }

    public int[] solution(int[] period, int[][] payments, int[] estimates){
        int[] answer = {};
        int[] paymentSum = {};
        boolean flagNow = true;
        boolean flagNext = true;
        int cntNow = 0;
        int cntNext = 0;

        //이번달 vip
        for (int i = 0; i < payments.length; i++) {
            for (int j = 0; j < payments[i].length; j++) {
                paymentSum[i] += payments[i][j];
            }
            if(period[i] < 24){ // 2
                flagNow = false;
            }
            if(24 <= period[i] && period[i] < 60){ // 2~5
                if(paymentSum[i] < 900000){
                    flagNow = false;
                }
            }
            if(period[i] >= 60){
                if(paymentSum[i] < 600000){
                    flagNow = false;
                }
            }
            // 다음달
            if(period[i]+1 < 24){
                flagNext = false;
            }
            if(24 <= period[i]+1 && period[i]+1 < 60){ // 2~5
                if(paymentSum[i]-payments[i][0]+estimates[i] < 900000){
                    flagNext = false;
                }
            }
            if(period[i]+1 >= 60){
                if(paymentSum[i]-payments[i][0]+estimates[i] < 600000){
                    flagNext = false;
                }
            }

            if(flagNow) cntNow++;
            if(flagNext) cntNext++;
        }

        answer[0] = cntNow;
        answer[1] = cntNext;

        return answer;
    }
}
