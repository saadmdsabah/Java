public class PrintBinaryStrings {

    public static void PrintBinary(int n, int lastpos, String sb){
        if(n == 0){
            System.out.println(sb);
            return;
        }
        PrintBinary(n-1, 0, sb+"0");
        if(lastpos == 0){
            PrintBinary(n-1, 1, sb+"1");
        }
    }
    public static void main(String[] args) {
        PrintBinary(3, 0, new String(""));
    }
}
