package DynamicProgramming.LongestCommonSubSequence;

public class LCA_Using_Recursion {

    public static int longestCA(String str1, String str2, int n, int m){
        if(n == 0 || m == 0){
            return 0;
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return 1 + longestCA(str1, str2, n-1, m-1); 
        }else{
            int ans1 = longestCA(str1, str2, n-1,m);
            int ans2 = longestCA(str1, str2, n, m-1);
            return Math.max(ans1, ans2);
        }
    }
    public static void main(String[] args) {
        String text1 = "abcdge";
        String text2 = "abedg";
        System.out.println(longestCA(text1,text2,text1.length(),text2.length()));
    }
}
