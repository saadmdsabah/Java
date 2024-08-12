package Array;

import java.util.ArrayList;
import java.util.Arrays;

public class PairSum2 {
    public static void main(String[] args) {
        // Sorted and Rotated ArrayList
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(11,15,6,8,9,10));
        int i=0,j=array.size()-1;
        for(int k=array.size()-1; k>0; k--){
            if(array.get(k) < array.get(k-1)){
                i = k;
                j = k-1;
                break;
            }
        }
        int target = 16;
        while (i != j) {
            if(array.get(i) + array.get(j) == target){
                System.out.println("The Pair is " + array.get(i) + ", " + array.get(j));
                return;
            }if(array.get(i) + array.get(j) > target){
                if(j-1 < 0){
                    j = array.size()-1;
                }else{
                    j--;
                }
            }else{
                if(i+1 >= array.size()){
                    i = 0;
                }else{
                    i++;
                }
            }
        }
    }
}
