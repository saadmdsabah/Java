public class RecursiveRange {

    public static int recursiveRange(int num) {
        if(num == 0){
            return 0;
        }
        return num+recursiveRange(num-1);
    } 
    public static void main(String[] args) {
        System.out.println(recursiveRange(6));
    }
}
