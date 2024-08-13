package bitmanipulation;

public class decimal2Binary {
    public static void main(String[] args) {
        int n = 5;
        String result = "";
        while (n>0) {
            result = result + n%2;
            n = n/2;
        }
        System.out.println(result);
    }
}