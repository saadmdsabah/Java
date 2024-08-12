package String;

public class StringBuilderInJava {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Saad");
        for(char c='a'; c<='z'; c++){
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
