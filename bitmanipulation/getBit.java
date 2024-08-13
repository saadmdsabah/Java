package bitmanipulation;

public class getBit {
    public static void main(String[] args) {
        int n = 5;
        int position = 2;
        int bitmask = 1<<position;

        if((bitmask&n) == 0){
            System.out.println("the bit was 0");
        }else{
            System.out.println("the bit was 1");
        }
    }
}
