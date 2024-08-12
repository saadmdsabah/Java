package DynamicProgramming.MatrixChainMultiplication;


public class MCS {

    public static int MatrixCM(int[] arr, int i, int j){
        if(i == j){
            return 0;
        }
        int result = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int ans1 = MatrixCM(arr, i, k);
            int ans2 = MatrixCM(arr, k+1, j);
            int ans3 = arr[i-1]*arr[k]*arr[j];
            int currSum = ans1+ans2+ans3;
            result = Math.min(currSum, result);
        }
        return result;
    }

    public static int MatrixCMMemoizatio(int[] arr, int i, int j, int dp[][]){
        if(i == j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int result = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int ans1 = MatrixCMMemoizatio(arr, i, k, dp);
            int ans2 = MatrixCMMemoizatio(arr, k+1, j, dp);
            int ans3 = arr[i-1]*arr[k]*arr[j];
            int currSum = ans1+ans2+ans3;
            result = Math.min(currSum, result);
        }
        return dp[i][j] = result;
    }

    public static int MatrixChainTabulation(int[] arr){
        int n = arr.length;
        int dp[][] = new int[n][n];

        for(int i=0; i<dp.length; i++){
            dp[i][i] = 0;
        }

        for(int len=2; len<n; len++){
            for(int i=1; i<=n-len; i++){
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<j; k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1]*arr[k]*arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1+cost2+cost3);
                }
            }
        }
        return dp[1][n-1];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3};
        int[][] dp = new int[arr.length+1][arr.length+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(MatrixCM(arr, 1, arr.length-1));
        System.out.println(MatrixCMMemoizatio(arr, 1, arr.length-1, dp));
        System.out.println(MatrixChainTabulation(arr));
    }
}
