public class BinaryToDecimal {

    public static int binaryTodecimal(int n, int pow){
        if(n==0){
            return 0;
        }
        return (int)Math.pow(2, pow)*(n%10) + binaryTodecimal(n/10, pow+1);
    }
    public static void main(String[] args) {
        System.out.println(binaryTodecimal(1100, 0));
    }
}
