package bitmanipulation;

public class binary2Decimal {
    public static void main(String[] args) {
        int n = 10;
        int result = 0;

        int power = 0;
        while (n > 0) {
            int bit = n&1;
            result += bit*Math.pow(2, power);
            n = n>>1;
            power++;
        }

        // Without Bit Manipulation
        // while (n>0) {
        //     int digit = n%10;
        //     result += digit*((int)Math.pow(2,power));
        //     power++;
        //     n = n/10;
        // }
        System.out.println(result);
    }
}
