package String;

public class StringCompression {
    public static void main(String[] args) {
        String input = "abcc";
        
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length(); i++){
            char temp = input.charAt(i);
            sb.append(temp);
            count = 1;
            while (i+1 < input.length() && temp == input.charAt(i+1)) {
                count++;
                i++;
            }
            if(count != 1){
                sb.append(count);
            }
        }
        System.out.println(sb.toString());
    }
}
