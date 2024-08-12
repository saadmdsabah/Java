package String;

public class CheckPalindrome {
    public static void main(String[] args) {
        String input = "SaaaS";
        int i=0,j=input.length()-1;
        while (j>i) {
            if(input.charAt(i) == input.charAt(j)){
                i++;j--;
            }else{
                System.out.println("False");
                return;
            }
        }
        System.out.println("True");
    }
}
