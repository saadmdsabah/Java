import java.util.Arrays;
import java.util.HashSet;

public class DP_For_MCM {

    public static int mcm_Recursion(int[] arr, int i, int j, int[][] dp){
        if(i == j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int result = arr[i-1]*arr[k]*arr[j] + mcm_Recursion(arr, i, k, dp) + mcm_Recursion(arr, k+1, j, dp);
            min = Math.min(result, min);
        }
        return dp[i][j] = min;
    }

    public static int mcm_topDown(int[] arr, int i, int j, int[][] dp){
        if(i == j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k=j; k>i; k--){
            int result = arr[i-1]*arr[k]*arr[j] + mcm_topDown(arr, i, k, dp) + mcm_topDown(arr, k+1, j, dp);
            min = Math.min(result, min);
        }
        return dp[i][j] = min;
    }

    public static int cutChoco(int start, int end, boolean[] taken, int[] cut, int[][] dp){
        if (start >= end) {
            return 0;
        }
        if(dp[start][end] != -1){
            return dp[start][end];
        }
        int result = Integer.MAX_VALUE;
        for (int k = 0; k < cut.length; k++) {
            if (!taken[k] && cut[k] > start && cut[k] <= end) {
                taken[k] = true;
                int cost = end - start + 1 + cutChoco(start, cut[k]-1, taken, cut, dp) + cutChoco(cut[k], end, taken, cut, dp);
                result = Math.min(result, cost);
                taken[k] = false;
            }
        }
        return dp[start][end] = result == Integer.MAX_VALUE ? 0 : result;
    }

    public static boolean expEval(String s, int start, int end, HashSet<Character> set){
        if(start == end){
            if(s.charAt(start) == 'T'){
                return true;
            }else{
                return false;
            }
        }
        boolean result = false;
        for(int i=start; i<=end; i++){
            if(set.contains(s.charAt(i))){
                if(s.charAt(i) == '&'){
                    result = expEval(s, start, i-1, set) & expEval(s, i+1, end, set);
                }else if(s.charAt(i) == '|'){
                    result = expEval(s, start, i-1, set) | expEval(s, i+1, end, set);
                }else{
                    result = expEval(s, start, i-1, set) ^ expEval(s, i+1, end, set);
                }
            }
        }
        return result;
    }

    public static boolean isPalindrom(String s, int i, int j){
        if(j - i + 1 == 1){
            return true;
        }
        while (i < j) {
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }

    public static int palinPar(String s, int start, int[] dp){
        if (start >= s.length()) {
            return 0;
        }
        if(dp[start] != -1){
            return dp[start];
        }
        int result = Integer.MAX_VALUE;
        for(int i=start; i<s.length(); i++){
            if(isPalindrom(s, start, i)){
                result = Math.min(result, 1+palinPar(s, i + 1, dp));
            }
        }
        return dp[start] = result;
    }

    public static void main(String[] args) {
        String s = "aababa";//bababcbadcede
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        System.out.println(palinPar(s,0, dp) - 1);
    }
}
