package Searching;

public class BinarySearch {
    public static void main(String[] args) {
        int array[] = {1,2,3,4,6,7,8};
        int high = array.length-1;
        int low = 0;
        int mid = (high-low)/2 + low;
        int target = 5;
        while (low <= high) {
            if(array[mid] == target){
                System.out.println("The number " + target +" is present at index " + mid);
                return;
            }
            else if(array[mid] > target){
                high = mid-1;
            }else{
                low = mid + 1;
            }
            mid = (high-low)/2 + low;
        }
        System.out.println("The Number doesn't Exist");
    }
}
