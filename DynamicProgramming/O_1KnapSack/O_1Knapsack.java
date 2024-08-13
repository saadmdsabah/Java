package DynamicProgramming.O_1KnapSack;

public class O_1Knapsack {

    public static int KnapSackReccursion(int[] val, int W[], int w, int n, int[][] dp){
        if(w == 0 || n == 0){
            return 0;
        }

        if(dp[n][w] != -1){
            return dp[n][w];
        }

        if(W[n-1] <= w){
            int ans1 = val[n-1] + KnapSackReccursion(val, W, w-W[n-1], n-1, dp);
            int ans2 = KnapSackReccursion(val, W, w, n-1, dp);
            dp[n][w] = Math.max(ans1, ans2);
            return dp[n][w];
        }else{
            dp[n][w] = KnapSackReccursion(val, W, w, n-1, dp);
            return dp[n][w];
        }
    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int W[] = {2,5,1,3,4};
        int w = 7;
        int n = val.length;
        int dp[][] = new int[n+1][w+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(KnapSackReccursion(val,W,w,val.length,dp));
    }
}
