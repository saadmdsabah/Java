package Array;

public class ReverseArray {
    public static void main(String[] args) {
        int[] array = {2,4,6,8,10};
        int i=0,j=array.length-1;
        while (i<j) {
            int temp = array[j];
            array[j] = array[i];
            array[i] = temp;
            i++;j--;
        }
        for(int k : array){
            System.out.print(k + " ");
        }
    }
}
