package bitmanipulation;

public class clearBit {
    public static void main(String[] args) {
        int n = 5;
        int position = 2;
        int bitmask = ~(1<<position);
        System.out.println(n&bitmask);
    }
}
