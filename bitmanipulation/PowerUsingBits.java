package bitmanipulation;

public class PowerUsingBits {
    public static void main(String[] args) {
        int n = 5;
        int power = 3;
        int ans = 1;

        while (power>0) {
            if((power & 1) != 0){
                ans = ans*n;
            }
            power = power>>1;
            n = n*n;
        }
        System.out.println(ans);
    }
}
