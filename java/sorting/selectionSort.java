public class selectionSort {
    public static void main(String[] args) {
        int[] array = {7,8,3,1,2,0};
        int j = 0;

        for(int i=0; i<array.length; i++){
            int smallest = array[i];
            int smallIndex = i;
            for(j=i; j<array.length; j++){
                if(array[j] < smallest){
                    smallest = array[j];
                    smallIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[smallIndex];
            array[smallIndex] = temp;
        }
        for(int i : array){
            System.out.print(i + " ");
        }

    }
}
