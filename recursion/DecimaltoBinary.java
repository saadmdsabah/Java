public class DecimaltoBinary {

    public static String decimalToBin(int n){
        if(n==0){
            return "";
        }
        return decimalToBin(n/2) + String.valueOf(n%2);
    }
    public static void main(String[] args) {
        System.out.println(decimalToBin(12));
    }
}
