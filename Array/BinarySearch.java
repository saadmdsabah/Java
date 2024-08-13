package Array;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {11, 15, 6, 8, 9, 10};
        int X = 16;
        Arrays.sort(arr);

        int i=0, j=arr.length-1;
        while (i<j) {
            if(arr[i] + arr[j] == X){
                System.out.println(true);
                return;
            }else if(arr[i] + arr[j] > X){
                j--;
            }else{
                i++;
            }
        }
        System.out.println(false);
    }
}
