package DynamicProgramming.LongestCommonSubSequence;

import java.util.Arrays;
import java.util.HashSet;

public class LongestIncreasingSubSequence {

    public static int longestCommon(int[] arr, int[] nums, int n, int m, int[][] dp){
        if(n == 0 || m == 0){
            return 0;
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        if(arr[n-1] == nums[m-1]){
            dp[n][m] = 1 + longestCommon(arr, nums, n-1, m-1, dp);
            return dp[n][m];
        }else{
            int ans1 = longestCommon(arr, nums, n-1, m, dp);
            int ans2 = longestCommon(arr, nums, n, m-1, dp);
            dp[n][m] = Math.max(ans1, ans2);
            return dp[n][m];
        }
    }
    public static void main(String[] args) {
        int[] nums = {30,3,10,7,40,80};
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int[] newNums = new int[set.size()];
        int j = 0;
        for(int i : set){
            newNums[j++] = i;
        }
        Arrays.sort(newNums);
        int[][] dp = new int[nums.length+1][newNums.length+1];
        for(int i=0; i<nums.length+1; i++){
            for(int k=0; k<newNums.length+1; k++){
                dp[i][k] = -1;
            }
        }
        System.out.println(longestCommon(nums, newNums, nums.length, newNums.length, dp));
    }
}
