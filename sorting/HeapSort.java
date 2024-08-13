public class HeapSort {

    public static void Heapify(int[] arr, int i, int size){
        int left = 2*i+1;
        int right = 2*i+2;
        int maxInd = i;

        if(left < size && arr[left] > arr[i]){
            maxInd = left;
        }

        if(right < size && arr[right] > arr[i]){
            maxInd = left;
        }
        if(maxInd != i){
            int temp = arr[maxInd];
            arr[maxInd] = arr[i];
            arr[i] = temp;

            Heapify(arr, maxInd, size);
        }
    }
    public static void heapSort(int arr[]){
        int n = arr.length;
        for(int i=n/2; i>=0; i--){
            Heapify(arr,i,n);
        }

        for(int i=n-1; i>0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            Heapify(arr,0,i);
        }
    }
    public static void main(String[] args) {
        int[] array = {1,3,2,5,4};
        heapSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }   
    }
}
