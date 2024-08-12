public class isArraySorted {
    public static boolean isSorted(int[] array, int index, int n){
        if(index == n-1){
            return true;
        }
        if(array[index] <= array[index+1]){
            return isSorted(array, index+1, n);
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(isSorted(new int[]{1,2,4,3}, 0, 4));
    }
}
