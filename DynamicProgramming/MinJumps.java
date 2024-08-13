package DynamicProgramming;

public class MinJumps {

    public static int MinJumpsRecursion(int[] arr, int index){
        if (arr[index] == 0) {
            return Integer.MAX_VALUE;
        }
        if(index >= arr.length-1){
            return 1;
        }
        int ans = arr[index];
        for(int i=1; i<=arr[index]; i++){
            ans = 1+Math.min(ans, MinJumpsRecursion(arr, index+i));
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,0,1,4};
        System.out.println(MinJumpsRecursion(arr, 0));
    }
}
