package StringMatchingAlgorithms;
public class NaiveAlgo {
    public static void main(String[] args) {
        String s = "abcbababcbabcabc";
        String pattern = "ab";

        int i=0;
        int j=0;
        while (i<s.length()) {
            if(s.charAt(i) == pattern.charAt(j)){
                i++;j++;
                while (i<s.length() && j<pattern.length()) {
                    if(s.charAt(i) == pattern.charAt(j)){
                        if(j == pattern.length()-1){
                            i = i - (j-1);
                            System.out.println(i-1);
                            j=0;
                            break;
                        }
                        i++;j++;
                    }else{
                        i = i - (j-1);
                        j=0;
                        break;
                    }
                }
            }else{
                i++;
            }
        }
    }
}
