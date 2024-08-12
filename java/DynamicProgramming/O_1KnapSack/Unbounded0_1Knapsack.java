package DynamicProgramming.O_1KnapSack;

public class Unbounded0_1Knapsack {

    public static int UnboundedKnapsack(int[] val, int[] wt, int W, int[][] dp, int n){
        if(W == 0 || n == 0){
            return 0;
        }
        if(dp[n][W] != -1){
            return dp[n][W];
        }
        if(W - wt[n-1] >= 0){
            int ans1 = val[n-1] + UnboundedKnapsack(val, wt, W-wt[n-1], dp, n);
            int ans2 = UnboundedKnapsack(val, wt, W, dp, n-1);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        }else{
            dp[n][W] = UnboundedKnapsack(val, wt, W, dp, n-1);
            return dp[n][W];
        }
    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;
        int[][] dp = new int[val.length+1][W+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(UnboundedKnapsack(val, wt, W, dp, val.length));
    }
}
