package Array;

public class SubArrays {
    public static void main(String[] args) {
        // Prefix Sum Approach
        // int[] array = {1,-2,6,-1,3};
        // int[] prefixSum = new int[array.length + 1];
        // prefixSum[1] = array[0];
        
        // for(int i=2; i<prefixSum.length; i++){
        //     prefixSum[i] = prefixSum[i-1] + array[i-1];
        // }
        // int max = Integer.MIN_VALUE;
        // for(int i=1; i<prefixSum.length; i++){
        //     for(int j=i; j<prefixSum.length; j++){
        //         max = Math.max(max,prefixSum[j]-prefixSum[i-1]);
        //     }
        // }
        // System.out.println(max);

        // Kadane's Algorithm for Max SubArray
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int currSum = 0;
        int max = 0;

        for(int i=0; i<array.length; i++){
            currSum = currSum + array[i] < 0 ? 0 : currSum + array[i];
            max = Math.max(max, currSum);
        }
        System.out.println(max);

    }
}
