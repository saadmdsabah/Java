import java.util.HashMap;
import java.util.HashSet;

public class DPonStrings {

    public static int O1knapsack(int[] wt, int[] val, int w, int i, int[][] dp){
        if (i >= wt.length) {
            return 0;
        }
        if (dp[i][w] != -1) {
            return dp[i][w];
        }
        int taken = Integer.MIN_VALUE;
        if (w >= wt[i]) {
            taken = val[i] + O1knapsack(wt, val, w - wt[i], i + 1, dp);
        }
        int nottake = O1knapsack(wt, val, w, i + 1, dp);
        return dp[i][w] = Math.max(taken, nottake);
    }

    public static int O1knapsackTopDown(int[] wt, int[] val, int w, int i, int[][] dp){
        if(i == 0){
            if(w >= wt[0]){
                return val[0];
            }else{
                return 0;
            }
        }
        if (dp[i][w] != -1) {
            return dp[i][w];
        }
        int taken = Integer.MIN_VALUE;
        if (w >= wt[i]) {
            taken = val[i] + O1knapsackTopDown(wt, val, w - wt[i], i - 1, dp);
        }
        int nottake = O1knapsackTopDown(wt, val, w, i - 1, dp);
        return dp[i][w] = Math.max(taken, nottake);
    }

    public static int O1knapsackTab(int[] wt, int[] val, int w){
        int[][] dp = new int[wt.length][w+1];
        for(int j=0; j<=w; j++){
            if(j >= wt[0]){
                dp[0][j] = val[0];
            }
        }
        for(int i=1; i<wt.length; i++){
            for(int j=0; j<=w; j++){
                int taken = Integer.MIN_VALUE;
                if (j >= wt[i]) {
                    taken = val[i] + dp[i - 1][j - wt[i]];
                }
                int nottake = dp[i-1][j];
                dp[i][j] = Math.max(taken, nottake);
            }
        }
        return dp[wt.length-1][w];
    }

    public static int MinimumElements(int[] num, int x, int i, int[][] dp){
        if(i == 0){
            if(x%num[i] == 0){
                return x/num[i];
            }else{
                return 1000000000;
            }
        }
        if(dp[i][x] != -1){
            return dp[i][x];
        }
        int take = Integer.MAX_VALUE;
        if(x >= num[i]){
            take = 1 + MinimumElements(num, x-num[i], i, dp);
        }
        int nottake = MinimumElements(num, x, i-1, dp);
        return dp[i][x] = Math.min(take, nottake);
    }

    public static int MinimumElementsTab(int[] num, int x){
        int[][] dp = new int[num.length][x+1];
        for(int j=0; j<=x; j++){
            if(j%num[0] == 0){
                dp[0][j] = j/num[0];
            }else{
                dp[0][j] = 1000000000;
            }
        }
        for(int i=1; i<num.length; i++){
            for(int j=0; j<=x; j++){
                int take = Integer.MAX_VALUE;
                if(j >= num[i]){
                    take = 1 + dp[i][j-num[i]];
                }
                int nottake = dp[i-1][j];
                dp[i][j] = Math.min(take, nottake);
            }
        }
        return dp[num.length-1][x];
    }

    // public static int targetSum(int[] target, int sum, int i, int curr){
    //     if(i == 0){
    //         if(curr + target[i] == sum || curr - target[i] == sum){
    //             return 1;
    //         }else{
    //             return 0;
    //         }
    //     }
    //     int taken = 0;
    //     if(curr >= target[i]){
    //         taken = targetSum(target, sum, i-1, curr-target[i]);
    //     }
    //     int nottake = targetSum(target, sum, i-1, curr+target[i]);
    //     return taken + nottake;
    // }

    public static int targetSum(int[] target, int sum, int i, int curr, int[][] dp) {
        if (i >= target.length) {
            return curr == sum ? 1 : 0;
        }
        if(dp[i][curr] != -1){
            return dp[i][curr];
        }
        int add = targetSum(target, sum, i + 1, curr + target[i], dp);
        int subtract = targetSum(target, sum, i + 1, curr - target[i], dp);
        return dp[i][curr] = add + subtract;
    }

    public static long coinChange(int[] nums, int tar, int i, long[][] dp){
        if(tar == 0){
            return 1;
        }
        if(i == nums.length){
            return 0;
        }
        if(dp[i][tar] != -1){
            return dp[i][tar];
        }
        long taken = 0;
        if(tar >= nums[i]){
            taken = coinChange(nums, tar-nums[i], i, dp);
        }
        long nottake = coinChange(nums, tar, i + 1, dp);
        return dp[i][tar] = taken + nottake;
    }

    public static long coinChangeTopdown(int[] nums, int tar, int i, long[][] dp){
        if(i == 0){
            if(tar%nums[0] == 0){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[i][tar] != -1){
            return dp[i][tar];
        }
        long taken = 0;
        if(tar >= nums[i]){
            taken = coinChangeTopdown(nums, tar-nums[i], i, dp);
        }
        long nottake = coinChangeTopdown(nums, tar, i - 1, dp);
        return dp[i][tar] = taken + nottake;
    }

    public static long coinChangeTab(int[] nums, int tar){
        long[][] dp = new long[nums.length][tar + 1];
        for(int i=0; i<=tar; i++){
            if(i%nums[0] == 0){
                dp[0][i] = 1;
            }
        }
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<=tar; j++){
                long taken = 0;
                if(j >= nums[i]){
                    taken = dp[i][j-nums[i]];
                }
                long nottake = dp[i-1][j];
                dp[i][j] = taken + nottake;
            }
        }
        return dp[nums.length-1][tar];
    }

    public static int O1knapsackUnbound(int[] wt, int[] val, int i, int w, int[][] dp){
        if(i == wt.length){
            return 0;
        }
        if(dp[i][w] != -1){
            return dp[i][w];
        }
        int take = 0;
        if(w >= wt[i]){
            take = val[i] + O1knapsackUnbound(wt, val, i, w-wt[i], dp);
        }
        int nottake = O1knapsackUnbound(wt, val, i + 1, w, dp);
        return dp[i][w] = Math.max(take, nottake);
    }

    public static int O1knapsackUnboundTopdown(int[] wt, int[] val, int i, int w, int[][] dp){
        if(i == 0){
            if(w >= wt[i]){
                return (w/wt[i])*val[i];
            }else{
                return 0;
            }
        }
        if(dp[i][w] != -1){
            return dp[i][w];
        }
        int take = 0;
        if(w >= wt[i]){
            take = val[i] + O1knapsackUnboundTopdown(wt, val, i, w-wt[i], dp);
        }
        int nottake = O1knapsackUnboundTopdown(wt, val, i - 1, w, dp);
        return dp[i][w] = Math.max(take, nottake);
    }

    public static int O1knapsackUnboundTab(int[] wt, int[] val, int w){
        int[][] dp = new int[wt.length][w + 1];
        for(int i=0; i<=w; i++){
            if(i >= wt[0]){
                dp[0][i] = (i/wt[0])*val[0];
            }
        }
        for(int i=1; i<wt.length; i++){
            for(int j=0; j<=w ;j++){
                int take = 0;
                if(j >= wt[i]){
                    take = val[i] + dp[i][j-wt[i]];
                }
                int nottake = dp[i - 1][j];
                dp[i][j] = Math.max(take, nottake);
            }
        }
        return dp[wt.length-1][w];
    }

    public static int rodCutting(int[] arr, int n, int i, int[][] dp){
        if(i == arr.length){
            return 0;
        }
        if(dp[i][n] != -1){
            return dp[i][n];
        }
        int take = 0;
        if(n >= i + 1){
            take = arr[i] + rodCutting(arr, n-i-1, i, dp);
        }
        int nottake = rodCutting(arr, n, i+1, dp);
        return dp[i][n] = Math.max(take, nottake);
    }

    public static int rodCuttingTopdown(int[] arr, int n, int i, int[][] dp){
        if(i == 0){
            if(n >= i+1){
                return n*arr[0];
            }else{
                return 0;
            }
        }
        if(dp[i][n] != -1){
            return dp[i][n];
        }
        int take = 0;
        if(n >= i + 1){
            take = arr[i] + rodCuttingTopdown(arr, n-i-1, i, dp);
        }
        int nottake = rodCuttingTopdown(arr, n, i-1, dp);
        return dp[i][n] = Math.max(take, nottake);
    }

    public static int rodCuttingTab(int[] arr, int n){
        int[][] dp = new int[arr.length][n+1];
        for(int i=0; i<=n; i++){
            if(i >= 1){
                dp[0][i] = i*arr[0];
            }
        }
        for(int i=1; i<arr.length; i++){
            for(int j=0; j<=n; j++){
                int take = 0;
                if(j >= i + 1){
                    take = arr[i] + dp[i][j-i-1];
                }
                int nottake = dp[i-1][j];
                dp[i][j] = Math.max(take, nottake);
            }
        }
        return dp[arr.length-1][n];
    }
    
    public static int lca(String s1, String s2, int i, int j, int[][] dp){
        if(i >= s1.length() || j >= s2.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int same = 0;
        int ifor = 0;
        int jfor = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            same = 1 + lca(s1, s2, i+1, j+1, dp);
        }else{
            ifor = lca(s1, s2, i+1, j, dp);
            jfor = lca(s1, s2, i, j+1, dp);            
        }
        return dp[i][j] = Math.max(same, Math.max(jfor, ifor));
    }

    public static int lcaTopdown(String s1, String s2, int i, int j, int[][] dp) {
		// Base case: if either string is exhausted, LCS is 0
		if (i == 0 || j == 0) {
			return 0;
		}
		// If the value is already computed, return it
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		// If the characters at the current positions match, include it in LCS
		if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
			dp[i][j] = 1 + lcaTopdown(s1, s2, i - 1, j - 1, dp);
		} else {
			// If characters don't match, try both possibilities and take the max
			dp[i][j] = Math.max(lcaTopdown(s1, s2, i - 1, j, dp), lcaTopdown(s1, s2, i, j - 1, dp));
		}
		return dp[i][j];
	}

    public static int lcaTab(String s1, String s2){
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i=0; i<=s1.length(); i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<=s2.length(); j++){
            dp[0][j] = 0;
        }
        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int i = s1.length();
        int j = s2.length();
        StringBuilder sb = new StringBuilder("");
        HashMap<Character, HashSet<Integer>> map = new HashMap<>();
        map.put('1', new HashSet<>());
        map.put('2', new HashSet<>());
        while (i > 0 && j > 0) {
            if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                sb.append(s1.charAt(i - 1));
                map.get('1').add(i-1);
                map.get('2').add(j-1);
                i--;j--;
            }else{
                if(dp[i-1][j] > dp[i][j-1]){
                    i--;
                }else{  
                    j--;
                }
            }
        }
        System.out.println(map);
        System.out.println(sb.reverse().toString());
        return dp[s1.length()][s2.length()];
    }

    public static int longestCommonPalindrom(String s, int i, int j, int[][] dp){
        if(i == j){
            return 1;
        }
        if(i > j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int same = 0;
        int t = 0;
        int r = 0;
        if(s.charAt(i) == s.charAt(j)){
            same = 2 + longestCommonPalindrom(s, i+1, j-1, dp);
        }else{
            t = longestCommonPalindrom(s, i+1, j, dp);
            r = longestCommonPalindrom(s, i, j-1, dp);
        }
        
        return dp[i][j]= Math.max(t, Math.max(same, r)); 
    }

    public static int minInsertions(String s, int i, int j, int[][] dp){
        if(i == j || i > j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int same = Integer.MAX_VALUE;
        int t = Integer.MAX_VALUE;
        int r = Integer.MAX_VALUE;
        if(s.charAt(i) == s.charAt(j)){
            same = minInsertions(s, i+1, j-1, dp);
        }else{
            t = 1 + minInsertions(s, i+1, j,dp);
            r = 1 + minInsertions(s, i, j-1,dp);
        }
        return dp[i][j] = Math.min(same, Math.min(r,t));
    }

    public static int distinctSubSeq(String s1, String s2, int i, int j, int[][] dp){
        if(j >= s2.length()){
            return 1;
        }
        if(i >= s1.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = distinctSubSeq(s1, s2, i+1,j+1, dp) + distinctSubSeq(s1, s2, i+1, j,dp);
        }
        return dp[i][j] = distinctSubSeq(s1, s2, i+1, j,dp);
    }

    public static int distinctSubSeqTopdown(String s1, String s2, int i, int j, int[][] dp){
        if(j < 0) return 1;
        if(i < 0) return 0;
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = distinctSubSeqTopdown(s1, s2, i-1, j-1, dp) + distinctSubSeqTopdown(s1, s2, i-1, j, dp);
        }
        return dp[i][j] = distinctSubSeqTopdown(s1, s2, i-1, j, dp);
    }

    public static int distinctSubSeqTab(String s1, String s2){
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        long mod = 1000000007;
        for(int i=0; i<=s1.length(); i++){
            dp[i][0] = 1;
        }
        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = (int) ((dp[i-1][j-1] + dp[i-1][j])%mod);
                }else{
                    dp[i][j] = (int)(dp[i-1][j]%mod);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static int editDistance(String s1, String s2, int i, int j, int[][] dp){
        if(i < 0){
            return j+1;
        }
        if(j < 0){
            return i+1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = editDistance(s1, s2, i-1, j-1,dp);
        }
        return dp[i][j] = 1 + Math.min(editDistance(s1, s2, i, j-1,dp), Math.min(editDistance(s1, s2, i-1, j,dp),editDistance(s1, s2, i-1, j-1,dp)));
    }

    public static boolean wildCard(String s1, String s2, int i, int j, int[][] dp) {
        if (i >= s1.length()) {
            return j >= s2.length();
        }
        if (j >= s2.length()) {
            for (int k = i; k < s1.length(); k++) {
                if (s1.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }
        if (s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?') {
            dp[i][j] = wildCard(s1, s2, i + 1, j + 1, dp) ? 1 : 0;
        } else if (s1.charAt(i) == '*') {
            dp[i][j] = wildCard(s1, s2, i + 1, j, dp) || wildCard(s1, s2, i, j + 1, dp) ? 1 : 0;
        } else {
            dp[i][j] = 0;
        }
        return dp[i][j] == 1;
    }

    public static void main(String[] args) {
        String s1 = "ba*a?";
        String s2 = "baaabab";
        int[][] dp = new int[s1.length()][s2.length()];
        for(int i=0; i<s1.length(); i++){
            for(int j=0; j<s2.length(); j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(wildCard(s1, s2, 0, 0, dp));
    }
}
