import java.util.ArrayList;

public class subsequence {

    public static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public static void subsequences(int[] arr, int index, ArrayList<Integer> temp){
        if(index >= arr.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        temp.add(arr[index]);
        subsequences(arr, index+1, temp);
        temp.remove(temp.size() - 1);
        subsequences(arr, index+1, temp);
    }
    public static void main(String[] args) {
        subsequences(new int[]{1,2,3}, 0, new ArrayList<Integer>());
        System.out.println(result);
    }
}
