public class QuickSort {
    
    public static int partition(int[] array, int low, int high){
        int pivot = array[high];
        int i = low-1;

        for(int j=low;j<high;j++){
            if(array[j] < pivot){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        i++;
        int temp = array[i];
        array[i] = pivot;
        array[high] = temp;
        return i;
    }

    public static void quickSort(int[] array, int low, int high){
        if(low < high){
            int pivotIndex = partition(array,low,high);
            quickSort(array, low, pivotIndex-1);
            quickSort(array, pivotIndex+1, high);
        }
    }
    public static void main(String[] args) {

        // Selecting pivot can be in the following ways:
        // 1) Random
        // 2) Median
        // 3) 1st element
        // 4) Last element (we will use this in here)

        int[] array = {6,3,9,5,2,8};
        int n = array.length;

        quickSort(array, 0, n-1);
        for(int i : array){
            System.out.print(i + "  ");
        }
    }
}
