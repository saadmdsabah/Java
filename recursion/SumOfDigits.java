public class SumOfDigits {

    public static int SumofDig(int n){
        if(n==0){
            return 0;
        }
        return n%10 + SumofDig(n/10);
    }
    public static void main(String[] args) {
        System.out.println(SumofDig(2346));
    }
}
