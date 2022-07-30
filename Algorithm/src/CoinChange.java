public class CoinChange {
    public static void main(String[] args) {
        int[] coin = {10,20,50};

        long result = napsac(50,coin);
        System.out.println(result);
    }

    public static long napsac(int target, int[] type){

        long[] dy = new long[target+1];
        // 인덱스 1부터 시작

        dy[0] = 1;
        // 최소의 개수인 1부터 시작

        for(int i=0; i<type.length; i++){

            for(int j=1; j<=target; j++){
                if(type[i] <= j){
                    dy[j] += dy[j-type[i]];
                    /*
                    ex.
                    type[i] = 10, j=11일때,
                    dy[11-10] = dy[1]
                    dy[11] += dy[1]
                    즉, dy[11] 자리에 dy[1] 의 값을 더해준다.
                    */
                }
            }
        }
        return dy[target];
    }
}
