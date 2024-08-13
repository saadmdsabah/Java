public class PowerOfDigigt {

    public static int powerOfDig(int n, int power){
        if(power == 0){
            return 1;
        }
        return n*powerOfDig(n, power-1);
    } 
    public static void main(String[] args) {
        System.out.println(powerOfDig(2, 5));
    }
}
