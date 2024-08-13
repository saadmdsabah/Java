package DynamicProgramming.LongestCommonSubSequence;

public class EditDistance {

    public static int editDistanceRecursion(String word1, String word2, int n, int m){
        if(n == 0 || m == 0){
            return 0;
        }
        if(word1.charAt(n-1) == word2.charAt(m-1)){
            return editDistanceRecursion(word1, word2, n-1, m-1);
        }else{
            int ans1 = 1+editDistanceRecursion(word1, word2, n, m-1);
            int ans2 = 1+editDistanceRecursion(word1, word2, n-1, m);
            int ans3 = 1+editDistanceRecursion(word1, word2, n-1, m-1);
            return Math.max(ans1, Math.min(ans2, ans3));
        }
    }

    public static int editDistanceMemoization(String word1, String word2, int n, int m, int[][] dp){
        if(n == 0){
            return m;
        }
        if(m == 0){
            return n;
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        if(word1.charAt(n-1) == word2.charAt(m-1)){
            dp[n][m] = editDistanceMemoization(word1, word2, n-1, m-1, dp);
            return dp[n][m];
        }else{
            int ans2 = 1+editDistanceMemoization(word1, word2, n, m-1, dp);
            int ans1 = 1+editDistanceMemoization(word1, word2, n-1, m, dp);
            int ans3 = 1+editDistanceMemoization(word1, word2, n-1, m-1, dp);
            dp[n][m] = Math.min(ans1, Math.min(ans2, ans3));
            return dp[n][m];
        }
    }

    public static int editDistanceTabulation(String word1, String word2, int n, int m){
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                if(i == 0){
                    dp[i][j] = j;
                }
                if(j == 0){
                    dp[i][j] = i;
                }
            }
        }
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[i].length; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int ans1 = 1+dp[i-1][j];
                    int ans2 = 1+dp[i][j-1];
                    int ans3 = 1+dp[i-1][j-1];
                    dp[i][j] = Math.min(ans1, Math.min(ans2, ans3)); 
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(editDistanceRecursion(word1, word2, word1.length(), word2.length()));
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(editDistanceMemoization(word1, word2, word1.length(), word2.length(), dp));
        System.out.println(editDistanceTabulation(word1, word2, word1.length(), word2.length()));
    }
}
