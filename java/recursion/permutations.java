public class permutations {

    public static void permutation(String s,String perm){
        if(s.length() == 0){
            System.out.println(perm);
            return;
        }
        for(int i=0;i<s.length();i++){
            char currChar = s.charAt(i);
            String newStr = s.substring(0, i) + s.substring(i+1);
            permutation(newStr, perm + currChar);
        }
    }
    public static void main(String[] args) {
        permutation("abc", "");
    }
}
