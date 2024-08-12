package Array;

public class KardanesAlgo {
    public static void main(String[] args) {    
        int[] arr = {1,3,5,-3,5,-2};
        int maxSum = 0;
        int currSum = 0;
        for(int i=0; i<arr.length; i++){
            currSum = currSum + arr[i] < 0 ? 0 : currSum + arr[i];
            maxSum = Math.max(currSum, maxSum);
        }
        System.out.println(maxSum);
    }
}
