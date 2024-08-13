public class MergeSort {

    public static void conquer(int[] array, int si, int mid, int ei){
        int merged[] = new int[ei - si + 1];
        int indx1 = si;
        int indx2 = mid+1;
        int x = 0;

        while (indx1 <= mid && indx2<=ei) {
            if(array[indx1] <= array[indx2]){
               merged[x++] = array[indx1++]; 
            } else{
                merged[x++] = array[indx2++];
            }
        }
        while (indx1 <= mid) {
            merged[x++] = array[indx1++];
        }

        while (indx2<=ei) {
            merged[x++] = array[indx2++];
        }

        for(int i=0,j=si;i<merged.length;i++,j++){
            array[j] = merged[i];
        }
    }

    public static void divide(int[] array, int si, int ei){
        if(si >= ei){
            return;
        }
        int mid = si + (ei-si)/2;
        divide(array, si, mid);
        divide(array, mid + 1, ei);
        conquer(array,si,mid,ei);
    }
    public static void main(String[] args) {
        int[] array = {6,3,9,5,2,8};
        int n = array.length;
        divide(array, 0, n-1);
        for(int i : array){
            System.out.print(i + " ");
        }
    }
}
