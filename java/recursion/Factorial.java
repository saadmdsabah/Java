public class Factorial {

    public static int Facto(int n){
        if(n<=1){
            return 1;
        }
        return n*Facto(n-1);
    }
    public static void main(String[] args) {
        System.out.println(Facto(5));
    }
}
