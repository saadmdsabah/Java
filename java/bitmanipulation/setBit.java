package bitmanipulation;

public class setBit {
    public static void main(String[] args) {
        int n = 5;
        int position = 1;
        int bitmask = 1<<position;
        System.out.println(n|bitmask);
    }
}
