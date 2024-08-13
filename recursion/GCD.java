public class GCD {

    public static int gcD(int a, int b){
        if(b == 0){
            return a;
        }
        return gcD(b, a%b);
    }
    public static void main(String[] args) {
        System.out.println(gcD(8, 4));
    }
}
