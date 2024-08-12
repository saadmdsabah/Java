public class bubbleSort {
    public static void main(String[] args) {
        int[] array = {7,8,3,1,2};
        
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        for(int i : array){
            System.out.print(i + " ");
        }
    }
}
