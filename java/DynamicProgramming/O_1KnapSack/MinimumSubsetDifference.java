package DynamicProgramming.O_1KnapSack;

public class MinimumSubsetDifference {

    public static int MinimumSubsetDifferenceMemoization(int[] number, int n, int[][] dp, int W){
        if(n == 0 || W == 0){
            return 0;
        }
        if(dp[n][W] != -1){
            return dp[n][W];
        }
        if(W - number[n-1] >= 0){
            int ans1 = number[n-1] + MinimumSubsetDifferenceMemoization(number, n-1, dp, W-number[n-1]);
            int ans2 = MinimumSubsetDifferenceMemoization(number, n-1, dp, W);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        }else{
            dp[n][W] = MinimumSubsetDifferenceMemoization(number, n-1, dp, W);
            return dp[n][W];
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,6,11,5};
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        int W = sum/2;
        
        int[][] dp = new int[nums.length+1][W+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(sum - 2*MinimumSubsetDifferenceMemoization(nums, nums.length, dp, W));
    }
}
