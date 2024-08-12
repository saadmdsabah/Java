public class PalindromeString {

    public static boolean isPalindrome(String s){
        if(s.length() == 1){
            return true;
        }
        return (s.charAt(s.length() - 1) == s.charAt(0)) && isPalindrome(s.substring(1,s.length()-1));
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("tacocat"));
    }
}
