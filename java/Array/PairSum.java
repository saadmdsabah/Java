package Array;
import java.util.Arrays;
// import java.util.HashSet;
import java.util.ArrayList;

public class PairSum {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        int target = 5;
        
        // Using HashSet Approach
        // HashSet<Integer> set = new HashSet<>();

        // for(int i : array){
        //     set.add(i);
        // }
        // for(int i:array){
        //     if(set.contains(target - i)){
        //         System.out.println("The Pair is " + i + ", " + (target - i));
        //     }
        // }

        // Two Pointer Approach
        int i=0,j=array.size()-1;
        while (i<j) {
            if(array.get(i) + array.get(j) == target){
                System.out.println("The pair is " + array.get(i) + ", " + array.get(j));
                return;
            }else if(array.get(i) + array.get(j) > target){
                j--;
            }else{
                i++;
            }
        }
        System.out.println("No pair Exists");
    }
}
