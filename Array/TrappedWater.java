package Array;

public class TrappedWater {
    public static void main(String[] args) {
        int[] height = {4,2,0,6,3,2,5};
        int[] rightHeight = new int[height.length];
        int[] leftHeight = new int[height.length];

        int rightMax = 0;
        int leftMax = 0;

        // Left to the Slabs
        for(int i=0; i<height.length; i++){
            leftHeight[i] = leftMax;
            leftMax = Math.max(leftMax, height[i]);
        }
        // Right to the Slabs
        for(int i=height.length-1; i>=0; i--){
            rightHeight[i] = rightMax;
            rightMax = Math.max(rightMax, height[i]);
        }

        // Finding the MinHeight and the sum
        int sum = 0;
        for(int i=0; i<height.length; i++){
            int minHeight = Math.min(leftHeight[i], rightHeight[i]);
            sum += minHeight - height[i] <= 0 ? 0 : minHeight - height[i];
        }
        System.out.println(sum);
    }
}
