package Pratice;

public class t {

    public static boolean WordBreakRecursion(String s, String[] wordDict, int index, String curr){
        if(curr.equals(s)){
            return true;
        }
        if(index == 0){
            return false;
        }
        if(curr.length() + wordDict[index-1].length() <= s.length()){
            boolean ans1 = WordBreakRecursion(s, wordDict,index, wordDict[index-1]+curr);
            boolean ans2 = WordBreakRecursion(s, wordDict, index, curr+wordDict[index-1]);
            boolean ans3 = WordBreakRecursion(s, wordDict, index-1, curr);
            return ans1 || ans2 || ans3;
        }else{
            return WordBreakRecursion(s, wordDict, index-1, curr);
        }
    }

    public static boolean WordBreakTabultaion(String s, String[] wordDict){
        boolean[] dp = new boolean[wordDict.length+1];
        dp[0] = false;

        return false;
    }

    public static void main(String[] args) {
        String s = "bb";
        String[] wordDict = {"a","b","bbb","bbbb"};
        int[] dp = new int[wordDict.length+1];
        for(int i=0; i<dp.length; i++){
            dp[i] = -1;
        }
        System.out.println(WordBreakRecursion(s,wordDict,wordDict.length,""));
    }
}
