

import java.util.ArrayList;

public class subSets {

    public static void subsets(int[] nums,ArrayList<ArrayList<Integer>> result,int index,ArrayList<Integer> temp){
        result.add(new ArrayList<>(temp));
        for(int i=index;i<nums.length;i++){
            temp.add(nums[i]);
            subsets(nums, result, i+1, temp);
            temp.remove(temp.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] nums = {3,1,2};
        ArrayList<ArrayList<Integer>> result= new ArrayList<>();
        subsets(nums, result ,0, new ArrayList<>());
        for(ArrayList<Integer> list : result){
            System.out.println(list);
        }
    }
}
