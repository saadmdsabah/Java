package DynamicProgramming.O_1KnapSack;

public class RodCutting {

    public static int rodMax(int[] price, int[][] dp, int n, int rodLength){
        if(n == 0 || rodLength == 0){
            return 0;
        }
        if(dp[n][rodLength] != -1){
            return dp[n][rodLength];
        }
        if(rodLength - n >= 0){
            int ans1 = price[n-1] + rodMax(price, dp, n, rodLength-n);
            int ans2 = rodMax(price, dp, n-1, rodLength);
            dp[n][rodLength] = Math.max(ans1, ans2);
            return dp[n][rodLength];
        }else{
            dp[n][rodLength] = rodMax(price, dp, n-1, rodLength);
            return dp[n][rodLength];
        }
    }
    public static void main(String[] args) {
        int[] len = {1,2,3,4,5,6,7,8};
        int[] price = {1,5,8,9,10,17,17,20};
        int rodLength = 8;
        int dp[][] = new int[len.length + 1][rodLength + 1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(rodMax(price, dp, len.length, rodLength));
    }
}
