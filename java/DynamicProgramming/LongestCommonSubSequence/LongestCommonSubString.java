package DynamicProgramming.LongestCommonSubSequence;

public class LongestCommonSubString {

    public static int longestSubstringTabulation(String str1, String str2){
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i=0; i<str1.length()+1; i++){
            dp[i][0] = 0;
        }
        for(int i=0; i<str2.length()+1; i++){
            dp[0][i] = 0;
        }
        for(int i=1; i<str1.length()+1; i++){
            for(int j=1; j<str2.length()+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        int val = 0;
        for(int i=0; i<str1.length()+1; i++){
            for(int j=0; j<str2.length()+1; j++){
                val = Math.max(val, dp[i][j]);
            }
        }
        return val;
    }
    public static void main(String[] args) {
        String str1 = "ABCDGH";
        String str2 = "ABCDHE";
        System.out.println(longestSubstringTabulation(str1, str2));
    }
}
