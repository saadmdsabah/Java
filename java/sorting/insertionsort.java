public class insertionsort {
    public static void main(String[] args) {
        int[] array = {7,1,8,2,3};
        for(int i=1; i<array.length; i++){
            int j = i;
            while (j>0 && array[j] < array[j-1]) {
                int temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
                j--;
            }
        }
        for(int i : array){
            System.out.print(i + " ");
        }
    }
}
