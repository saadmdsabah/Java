package DynamicProgramming.O_1KnapSack;

public class TargetSum {

    public static int targetSum(int[] numbers, int n, int target, int dp[][]){
        if(n==0 || target == 0){
            return target;
        }
        if(dp[n][target] != -1){
            return dp[n][target];
        }
        if(target - numbers[n-1] >= 0){
            int ans1 = targetSum(numbers, n-1, target-numbers[n-1], dp);
            int ans2 = targetSum(numbers, n-1, target, dp);
            dp[n][target] = Math.min(ans1, ans2);
            return dp[n][target];
        }else{
            dp[n][target] = targetSum(numbers, n-1, target, dp);
            return dp[n][target];
        }
    }
    public static void main(String[] args) {
        int[] numbers = {4,2,7,1,3};
        int target = 19;
        int[][] dp = new int[numbers.length+1][target+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(targetSum(numbers, numbers.length, target, dp));
    }
}
