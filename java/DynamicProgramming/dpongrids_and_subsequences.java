package DynamicProgramming;
import java.util.ArrayList;
import java.util.Arrays;

public class dpongrids_and_subsequences {

    public static int count(int n){
        if(n == 1){
            return 1;
        }
        int number = count(n - 1);
        System.out.println(number);
        return number + 1;
    }

    public static void count1ton(int i, int n){
        if(i > n){
            return;
        } 
        count1ton(i+1, n);
        System.out.println(i);
    }

    public static int sum(int i){
        if(i == 0){
            return 0;
        }
        return i + sum(i-1);
    }

    public static void reverse(int[] arr, int i, int j){
        if(i >= j){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        reverse(arr, i+1, j-1);
    }

    public static boolean palin(String s, int i){
        if(i >= s.length()/2){
            return true;
        }
        return s.charAt(i) == s.charAt(s.length() - i - 1) && palin(s, i+1);
    }

    public static void reverse(int[] arr, int i){
        if(i >= arr.length/2){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = temp;
        reverse(arr, i+1);
    }

    public static int fibo(int i){
        if(i == 0){
            return 0;
        }
        if(i == 1){
            return 1;
        }
        if(i == 2){
            return 1;
        }
        return fibo(i - 1) + fibo(i - 2);
    }

    public static void subsequnces(int[] arr, ArrayList<Integer> list, int i){
        if(i >= arr.length){
            System.out.println(list);
            return;
        }

        list.add(arr[i]);
        subsequnces(arr, list, i + 1);
        list.remove(list.size() - 1);

        subsequnces(arr, list, i + 1);
    }

    public static void subsequnces(int[] arr, ArrayList<Integer> list, int i, int sum, int target){
        if(i >= arr.length){
            if(sum == target){
                System.out.println(list);
            }
            return;
        }

        list.add(arr[i]);
        subsequnces(arr, list, i + 1, sum + arr[i], target);
        list.remove(list.size() - 1);

        subsequnces(arr, list, i + 1, sum, target);
    }

    public static int subsequncesint(int[] arr, int i, int sum, int target){
        if(i >= arr.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }

        int taken = subsequncesint(arr, i + 1, sum + arr[i], target);
        int nottaken = subsequncesint(arr, i + 1, sum, target);
        return taken + nottaken;
    }

    static int result = Integer.MAX_VALUE;
    public static int jump(int[] arr, int curr, int[] dp){
        if(curr == 0){
            return 0;
        }
        if(dp[curr] != -1){
            return dp[curr];
        }
        int left = jump(arr, curr - 1, dp) + Math.abs(arr[curr] - arr[curr - 1]);
        if(curr > 1){
            int right = jump(arr, curr - 2, dp) + Math.abs(arr[curr] - arr[curr - 2]);
            return dp[curr] = Math.min(right, left);
        }
        
        return dp[curr] = left;
    }

    public static int stairs(int n){
        if(n <= 3){
            return n;
        }
        int onejump = stairs(n - 1);
        int twojump = stairs(n - 2);
        return onejump + twojump;
    }

    public static int subsequncesAdj(int[] nums, int curr, int taken, int[] dp){
        if(curr >= nums.length){
            return 0;
        }
        if(dp[curr] != -1){
            return dp[curr];
        }
        int taken_sum = 0;
        if(taken == 0){
            taken_sum = subsequncesAdj(nums, curr + 1, 1, dp) + nums[curr];
        }
        int nottaken = subsequncesAdj(nums, curr + 1, 0, dp);
        return dp[curr] = Math.max(taken_sum, nottaken);
    }

    public static int subsequncesAdj(int[] nums, int curr, int[] dp){
        if(curr < 0){
            return 0;
        }
        if(dp[curr] != -1){
            return dp[curr];
        }
        if(curr == 0){
            return nums[curr];
        }
        int taken = subsequncesAdj(nums, curr - 2, dp) + nums[curr];
        int nottaken = subsequncesAdj(nums, curr - 1, dp);
        return Math.max(taken, nottaken);
    }

    public static int subsequncesAdj(int[] nums, int curr, int taken, int[][] dp) {
        if (curr >= nums.length) {
            return 0;
        }
        if (dp[curr][taken] != -1) {
            return dp[curr][taken];
        }
        int taken_sum = 0;
        if (taken == 0) {
            taken_sum = subsequncesAdj(nums, curr + 1, 1, dp) + nums[curr];
        }
        int nottaken = subsequncesAdj(nums, curr + 1, 0, dp);
        return dp[curr][taken] = Math.max(taken_sum, nottaken);
    }

    public static int ninja(int[][] nums, int col, int curr, int[][] dp){
        if(curr >= nums.length){
            return 0;
        }
        if(col != -1 && dp[curr][col] != -1){
            return dp[curr][col];
        }
        int result = Integer.MIN_VALUE;
        for(int i=0; i<3; i++){
            if(i != col){
                result = Math.max(result, ninja(nums, i, curr + 1, dp) + nums[curr][i]);
            }
        }
        return dp[curr][col] = result;
    }

    public static int ninjaTopDown(int[][] nums, int col, int curr, int[][] dp){
        if(curr < 0){
            return 0;
        }
        if(curr == 0){
            int max = 0;
            for(int i=0; i<3; i++){
                if(i == col){
                    continue;
                }
                max = Math.max(max, nums[0][i]);
            }
            return max;
        }
        if(dp[curr][col] != -1){
            return dp[curr][col];
        }
        int result = Integer.MIN_VALUE;
        for(int i=0; i<3; i++){
            if(i != col){
                result = Math.max(result, ninjaTopDown(nums, i, curr - 1, dp) + nums[curr][i]);
            }
        }
        return dp[curr][col] = result;
    }

    public static int paths(int[][] grid, int i, int j,int[][] dp){
        if(i == grid.length - 1 && j == grid[0].length - 1){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int right = 0;
        int down = 0;
        if(j + 1 < grid[0].length){
            right = paths(grid, i, j+1, dp);
        }
        if(i + 1 < grid.length){
            down = paths(grid, i+1, j, dp);
        }
        return dp[i][j] = right + down;
    }

    public static int pathsTopDown(int[][] grid, int i, int j, int[][] dp){
        if(i == 0 && j == 0){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int right = 0;
        int down = 0;
        if(i - 1 >= 0){
            right = pathsTopDown(grid, i-1, j, dp);
        }
        if(j - 1 >= 0){
            down = pathsTopDown(grid, i, j-1, dp);
        }
        return dp[i][j] = right + down;
    }

    public static int paths2(int[][] grid, int i, int j){
        if(grid[i][j] == -1){
            return 0;
        }
        if(i == grid.length-1 && j == grid[0].length - 1){
            return 1;
        }
        int right = 0;
        int down = 0;
        if(i + 1 < grid.length){
            right = paths2(grid, i + 1, j);
        }
        if(j+1 < grid[0].length){
            down = paths2(grid, i, j+1);
        }
        return right + down;
    }

    public static int paths2topdown(int[][] grid, int i, int j, int[][] dp){
        if(grid[i][j] == -1){
            return 0;
        }
        if(i == 0 && j == 0){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int right = 0;
        int down = 0;
        if(i-1 >= 0){
            right = paths2topdown(grid, i-1, j, dp);
        }
        if(j-1 >= 0){
            down = paths2topdown(grid, i, j-1, dp);
        }
        return dp[i][j] = right+down;
    }

    public static int minpath(int[][] grid, int i, int j, int[][] dp){
        if(i == grid.length - 1 && j == grid[0].length - 1){
            return grid[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        if(i + 1 < grid.length){
            right = grid[i][j] + minpath(grid, i+1, j, dp);
        }
        if(j + 1 < grid[0].length){
            down = grid[i][j] + minpath(grid, i, j+1, dp);
        }
        return dp[i][j] = Math.min(right, down);
    }

    public static int minpathTopdown(int[][] grid, int i, int j, int[][] dp){
        if(i == 0 && j == 0){
            return grid[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        if(i - 1 >= 0){
            right = grid[i][j] + minpathTopdown(grid, i-1, j, dp);
        }
        if(j - 1 >= 0){
            down = grid[i][j] + minpathTopdown(grid, i, j-1, dp);
        }
        return dp[i][j] = Math.min(right, down);
    }

    public static int pathTri(ArrayList<Integer>[] triangle, int curr, int col, ArrayList<Integer>[] dp){
        if(curr == triangle.length - 1){
            return triangle[curr].get(col);
        }
        if(dp[curr].get(col) != -1){
            return dp[curr].get(col);
        }
        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        if(curr + 1 < triangle.length){
            right = pathTri(triangle, curr + 1, col, dp) + triangle[curr].get(col);
        }
        if(curr + 1 < triangle.length && col + 1 < triangle[curr + 1].size()){
            down = pathTri(triangle, curr + 1, col + 1, dp) + triangle[curr].get(col);
        }
        dp[curr].set(col, Math.min(right, down));
        return Math.min(right, down);
    }

    public static int pathTriTopdown(ArrayList<Integer>[] triangle, int curr, int col, ArrayList<Integer>[] dp){
        if(curr == 0 && col == 0){
            return triangle[curr].get(col);
        }
        if(dp[curr].get(col) != -1){
            return dp[curr].get(col);
        }
        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        if(curr - 1 >= 0 && col < triangle[curr - 1].size()){
            right = pathTriTopdown(triangle, curr - 1, col, dp) + triangle[curr].get(col);
        }
        if(curr - 1 >= 0 && col - 1 < triangle[curr - 1].size() && col - 1 >= 0){
            down = pathTriTopdown(triangle, curr - 1, col - 1, dp) + triangle[curr].get(col);
        }
        dp[curr].set(col, Math.min(right, down));
        return Math.min(right, down);
    }

    public static void createTraingle(ArrayList<Integer>[] triangle){
        for(int i=0; i<4; i++){
            triangle[i] = new ArrayList<>();
        }
        triangle[0].add(1);

        triangle[1].add(2);
        triangle[1].add(3);        

        triangle[2].add(6);
        triangle[2].add(6);
        triangle[2].add(7);

        triangle[3].add(8);
        triangle[3].add(9);
        triangle[3].add(6);
        triangle[3].add(10);
    }

    public static int pathzigzag(int[][] grid, int curr, int col, int[][] dp){
        if(curr == grid.length - 1){
            return grid[curr][col];
        }
        if(dp[curr][col] != -1){
            return dp[curr][col];
        }
        int down = Integer.MIN_VALUE;
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        if(curr + 1 < grid.length){
            down = pathzigzag(grid, curr + 1, col, dp) + grid[curr][col];
        }
        if(col + 1 < grid[0].length && curr + 1 < grid.length){
            right = pathzigzag(grid, curr + 1, col + 1, dp) + grid[curr][col];
        }
        if(curr + 1 < grid.length && col - 1 >= 0){
            left = pathzigzag(grid, curr + 1, col - 1, dp) + grid[curr][col];
        }
        return dp[curr][col] = Math.max(left, Math.max(down, right));
    }

    public static int cherryPicking(int[][] grid, int i, int j1, int j2, int m, int[][][] dp){
        if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m ){
            return 0;
        }
        if(dp[i][j1][j2] != -1){
            return dp[i][j1][j2];
        }
        if(i == grid.length - 1){
            if(j1 == j2){
                return grid[i][j1];
            }else{
                return grid[i][j1] + grid[i][j2];
            }
        }
        int result = 0;
        for(int a=-1; a<2; a++){
            for(int b=-1; b<2; b++){
                if(j1 == j2){
                    result = Math.max(result, cherryPicking(grid, i+1, j1+a, j2+b, m, dp) + grid[i][j1]);
                }else{
                    result = Math.max(result, cherryPicking(grid, i+1, j1+a, j2+b, m, dp) + grid[i][j1] + grid[i][j2]);
                }
            }
        }
        return dp[i][j1][j2] = result;
    }

    public static boolean subseqSum(int[] arr, int k, int sum, int i, int[][] dp){
        if (sum == k) {
            return true;
        }
        if (sum > k || i >= arr.length) {
            return false;
        }
        if (dp[i][sum] != -1) {
            return dp[i][sum] == 1;
        }
        boolean taken = subseqSum(arr, k, sum + arr[i], i + 1, dp);
        boolean notTaken = subseqSum(arr, k, sum, i + 1, dp);
        dp[i][sum] = taken || notTaken ? 1 : 0;
        return taken || notTaken;
    }

    public static boolean subseqSumTopDown(int[] arr, int k, int sum, int i, int[][] dp){
        if(sum == k){
            return true;
        }
        if(i < 0 || sum > k){
            return false;
        }
        if (dp[i][sum] != -1) {
            return dp[i][sum] == 1;
        }
        boolean taken = subseqSumTopDown(arr, k, sum + arr[i], i - 1, dp);
        boolean notTaken = subseqSumTopDown(arr, k, sum, i - 1, dp);
        dp[i][sum] = taken || notTaken ? 1 : 0;
        return taken || notTaken;
    }

    public static int n_k(int n, int k, int start, int i, int[][] dp){
        if(i == n){
            return 1;
        }
        if(start > k){
            return 0;
        }
        if(dp[i][start]!=-1){
            return dp[i][start];
        }
        int result = 0;
        for(int j=start; j<=k; j++){
            result += n_k(n, k, j*2, i+1, dp);
        }
        return dp[i][start] = result;
    }

    public static boolean partitionArr(int[] arr, int i, int sum, int curr, int[][] dp){
        if(curr == sum){
            return true;
        }
        if(i == arr.length){
            return false;
        }
        if(dp[i][sum] != -1){
            return dp[i][sum] == 1;
        } 
        boolean taken = partitionArr(arr, i+1, sum-arr[i], curr+arr[i], dp);
        boolean nottaken = partitionArr(arr, i+1, sum, curr, dp);
        dp[i][sum] = taken || nottaken == true ? 1 : 0;
        return taken || nottaken;
    }

    public static boolean partitionDivide(int[] arr, int i, int sum){
        if(sum == 0){
            return true;
        }
        if(i == arr.length){
            return false;
        }
        boolean take = false;
        if(sum >= arr[i]){
            take = partitionDivide(arr, i + 1, sum - arr[i]);
        }
        boolean nottake = partitionDivide(arr, i + 1, sum);
        return take || nottake;
    }

    public static boolean partitionDivideTopDown(int[] arr, int i, int sum){
        if(i == 0){
            return (sum - arr[0] == 0);
        }
        if(sum == 0){
            return true;
        }
        boolean take = false;
        if(sum >= arr[i]){
            take = partitionDivideTopDown(arr, i - 1, sum - arr[i]);
        }
        boolean nottake = partitionDivideTopDown(arr, i - 1, sum);
        return take || nottake;
    }

    public static int minimumDiff(int[] arr, int i, int sum, int curr, int[][] dp){
        if(i == arr.length){
            return Math.abs(sum - curr);
        }
        if(dp[i][sum] != -1){
            return dp[i][sum];
        }
        int taken = Integer.MAX_VALUE;
        if(sum >= arr[i]){
            taken = minimumDiff(arr, i + 1, sum - arr[i], curr + arr[i], dp);
        }
        int nottaken = minimumDiff(arr, i + 1, sum, curr, dp);
        return dp[i][sum] = Math.min(taken, nottaken);
    }

    public static int minimumDiffTopDown(int[] arr, int i, int sum, int curr, int[][] dp){
        if(i == 0){
            return Math.min(Math.abs((sum - arr[0]) - (curr + arr[0])), Math.abs(sum-curr));
        }
        if(dp[i][sum] != -1){
            return dp[i][sum];
        }
        int taken = Integer.MAX_VALUE;
        if(sum >= arr[i]){
            taken = minimumDiffTopDown(arr, i - 1, sum - arr[i], curr + arr[i], dp);
        }
        int nottaken = minimumDiffTopDown(arr, i - 1, sum, curr, dp);
        return dp[i][sum] = Math.min(taken, nottaken);
    }

    public static int minDiff(int[] arr, int i, int sum, int curr){
        if(i == arr.length){
            return Math.abs((sum-curr) - curr);
        }
        int taken = Integer.MAX_VALUE;
        if(sum - curr - curr - arr[i] - arr[i] >= 0){
            taken = minDiff(arr, i+1, sum, curr+arr[i]);
        }
        int nottake = minDiff(arr, i + 1, sum, curr);
        return Math.min(taken, nottake);
    }

    public static int minDiffTopdown(int[] arr, int i, int sum, int curr, int[][] dp){
        if(i == 0){
            return Math.min(Math.abs((sum-curr) - curr), Math.abs((sum-curr-arr[0]) - curr-arr[0]));
        }
        if(dp[i][sum]!= -1){
            return dp[i][sum];
        }
        int taken = Integer.MAX_VALUE;
        if(sum - curr - curr - arr[i] - arr[i] >= 0){
            taken = minDiffTopdown(arr, i-1, sum, curr+arr[i], dp);
        }
        int nottake = minDiffTopdown(arr, i-1, sum, curr, dp);
        return dp[i][sum] = Math.min(taken, nottake);
    }

    public static int minDiffTopdown_Tabulation(int[] arr, int i, int sum, int curr){
        int[][] dp = new int[arr.length][sum+1];
        for(int j=0; j<=sum; j++)
            dp[0][j] = Math.min(Math.abs((sum - arr[0]) - (j + arr[0])), Math.abs(sum-j));
        
        for(int j=1; j<arr.length; j++) {
            for(int k=0; k<=sum; k++){
                int taken = Integer.MAX_VALUE;
                if(sum - k - k - arr[j] - arr[j] >= 0){
                    taken = dp[j-1][k+arr[j]];
                }
                int nottake = dp[j-1][k];
                dp[j][k] =  Math.min(taken, nottake);
            }
        }
        for(int[] y: dp)
            System.out.println(Arrays.toString(y));
        return dp[arr.length-1][sum-1];
    }

    public static boolean partitionDivideTopDownMin(int[] arr, int i, int sum, int[][] dp){
        if(i == 0){
            return (sum - arr[0] == 0);
        }
        if(sum == 0){
            return true;
        }
        if(dp[i][sum] != -1){
            return dp[i][sum] == 1;
        }
        boolean take = false;
        if(sum >= arr[i]){
            take = partitionDivideTopDown(arr, i - 1, sum - arr[i]);
        }
        boolean nottake = partitionDivideTopDown(arr, i - 1, sum);
        dp[i][sum] = take || nottake == true ? 1 : 0;
        return take || nottake;
    }

    public static int noofSubsets(int[] arr, int i, int tar, int[][] dp){
        if(tar == 0){
            return 1;
        }
        if(i == 0){
            return arr[0] == tar ? 1 : 0;
        }
        if(dp[i][tar] != -1){
            return dp[i][tar];
        }
        int take = 0;
        int nottake = noofSubsets(arr, i-1, tar, dp);
        if(tar >= arr[i]){
            take = noofSubsets(arr, i-1, tar-arr[i], dp);
        }
        return dp[i][tar] = take + nottake;
    }

    public static int noofSubsetsTab(int[] arr, int tar){
        int[][] dp = new int[arr.length][tar + 1];
        for(int i=0; i<arr.length; i++){
            dp[i][0] = 1;
        }
        if(arr[0] == tar){
            dp[0][tar] = 1;
        }
        for(int i=1; i<arr.length; i++){
            for(int j=0; j<=tar; j++){
                int take = 0;
                int nottake = dp[i-1][j];
                if(j >= arr[i]){
                    take = dp[i-1][j-arr[i]];
                }
                dp[i][j] = take + nottake;
            }
        }
        return dp[arr.length-1][tar];
    }

    public static void main(String[] args) {
        
    }
}
