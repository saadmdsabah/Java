public class Fibbonaci {

    public static int fibbO(int n){
        if(n==0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        return fibbO(n-2) + fibbO(n-1);
    }
    public static void main(String[] args) {
        System.out.println(fibbO(10));
    }
}
