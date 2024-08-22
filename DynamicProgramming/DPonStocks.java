package DynamicProgramming;
import java.util.Arrays;
public class DPonStocks {

    public static int buy2(int[] arr,int ind, int buy, int[][] dp){
        if(ind == arr.length){
            return 0;
        }
        if(dp[ind][buy] != -1){
            return dp[ind][buy];
        }
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-arr[ind] + buy2(arr, ind+1, 0, dp), buy2(arr, ind+1, 1,dp));
        }else{
            profit = Math.max(arr[ind] + buy2(arr, ind+1, 1,dp), buy2(arr, ind+1, 0,dp));
        }
        return dp[ind][buy] = profit;
    }

    public static int buy3(int[] arr, int ind, int buy, int k, int[][][] dp){
        if(k == 0 || ind >= arr.length){
            return 0;
        }
        if(dp[ind][k][buy] != -1){
            return dp[ind][k][buy];
        }
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-arr[ind] + buy3(arr, ind+1, 0,k, dp), buy3(arr, ind+1, 1,k,dp));
        }else{
            profit = Math.max(arr[ind] + buy3(arr, ind+1, 1,k-1,dp), buy3(arr, ind+1, 0,k,dp));
        }
        return dp[ind][k][buy] = profit;
    }

    public static int lis(int[] arr,int i,int[][] dp, int prev){
        if(i >= arr.length){
            return 0;
        }
        if(dp[i][prev + 1] != -1){
            return dp[i][prev + 1];
        }
		int len = lis(arr,i+1,dp, prev);
        if(prev == -1 || arr[i] > arr[prev]){
            len = Math.max(len,1 + lis(arr, i+1, dp, i));
        }
        return dp[i][prev + 1] = len;
        
    }

    public static int lisTab(int[] arr){
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        for(int i=arr.length - 1; i>=0; i--){
            for(int prev=-1; prev<i; prev++){
                int len = dp[i+1][prev+1];
                if(prev == -1 || arr[i] > arr[prev]){
                    len = Math.max(len, 1 + dp[i+1][i+1]);
                }
                dp[i][prev + 1] = len;
            }
        }
        return dp[0][0];
    }

    public static int lis2(int[] arr, int i, int prev, int[][] dp){
        if(i >= arr.length){
            return 0;
        }
        if(dp[i][prev + 1] != -1){
            return dp[i][prev + 1];
        }
        int len = lis2(arr, i+1, prev, dp);
        if(prev == -1 || arr[i] % arr[prev] == 0){
            len = Math.max(len,1+ lis2(arr, i + 1, i, dp));
        }
        return dp[i][prev + 1] = len;
    }

    public static int lis2Tab(int[] arr){
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        for(int i=arr.length - 1; i>=0; i--){
            for(int prev=-1; prev<i; prev++){
                int len = dp[i+1][prev+1];
                if(prev == -1 || arr[i] % arr[prev] == 0){
                    len = Math.max(len, 1 + dp[i+1][i+1]);
                }
                dp[i][prev + 1] = len;
            }
        }
        return dp[0][0];
    }

    public static boolean sameWord(String s, String t){
        if(Math.abs(s.length() - t.length()) != 1){
            return false;
        }
        int take = 0;
        int i = 0;
        int j = 0;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;j++;
            }else{
                if(take == 1){
                    return false;
                }
                take+=1;
                i++;
            }
        }
        if(take == 1 && (i < s.length() || j < t.length())){
            return false;
        }
        return true;
    }

    public static int lis3(String[] arr, int i, int prev, int[][] dp){
        if(i >= arr.length){
            return 0;
        }
        if(dp[i][prev + 1] != -1){
            return dp[i][prev + 1];
        }
        int len = lis3(arr, i+1, prev, dp);
        if(prev == -1 || sameWord(arr[i], arr[prev])){
            len = Math.max(len,1+ lis3(arr, i + 1, i, dp));
        }
        return dp[i][prev + 1] = len;
    }

    public static void main(String[] args) {
        String[] arr = {"a","bc", "ad","adc","bcd"};
        Arrays.sort(arr);
        int[][] dp = new int[arr.length][arr.length + 1];
        for(int i[] : dp){
            Arrays.fill(i, -1);
        }
        System.out.println(lis3(arr, 0, -1, dp));
    }
}
