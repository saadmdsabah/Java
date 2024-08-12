package StringMatchingAlgorithms;
public class KMP {
    public static void main(String[] args) {
        String input = "AAAXAAAAAX";     
        String s = "AAAA";
        int[] lps = new int[s.length()];
        lps[0] = 0;
        
        int j = 0;
        int i = 1;

        // Making the Table
        while (i<s.length()) {
            if(s.charAt(i) == s.charAt(j)){
                lps[i] = j + 1;
                j++;
                i++;
            }else{
                if(j == 0){
                    lps[i] = 0;
                    i++;
                }else{
                    j = lps[j-1];
                }
            }
        }

        // KMP Algorithm
        i=0;j=0;
        while (i<input.length()) {
            if(input.charAt(i) == s.charAt(j)){
                i++;j++;
            }else{
                if(j == 0){
                    i++;
                }else{
                    j = lps[j-1];
                }
            }
            if(j == s.length()){
                System.out.println(i-s.length());
                j = lps[j-1];
            }
        }
    }
}
