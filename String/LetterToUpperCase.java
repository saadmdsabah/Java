package String;

public class LetterToUpperCase {

    public static String LetterUpperCase(String str){
        StringBuilder sb = new StringBuilder("");
        sb.append(str.charAt(0));

        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) == ' ' && i+1<str.length()){
                sb.append(str.charAt(i));  
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "hi, i am saad";
        System.out.println(LetterUpperCase(str));
    }
}
