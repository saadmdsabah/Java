package DynamicProgramming.LongestCommonSubSequence;

public class LCA_Using_DP {

    public static int longestCA(String str1, String str2, int n, int m,int dp[][]){
        if(n == 0 || m == 0){
            return 0;
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)){
            dp[n][m] = 1 + longestCA(str1, str2, n-1, m-1,dp);
            return dp[n][m];
        }else{
            int ans1 = longestCA(str1, str2, n-1,m, dp);
            int ans2 = longestCA(str1, str2, n, m-1, dp);
            dp[n][m] = Math.max(ans1, ans2);
            return dp[n][m];
        }
    }

    public static int longestCATabluation(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<n; i++){
            dp[i][0] = 0;
        }
        for(int i=0; i<m; i++){
            dp[0][i] = 0;
        }
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String text1 = "abcdgefffwgoskfiqitnnv";
        String text2 = "abedgckewjnsjwhbfhf";
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(longestCATabluation(text1, text2));
        System.out.println(longestCA(text1,text2,text1.length(),text2.length(),dp));
    }
}
