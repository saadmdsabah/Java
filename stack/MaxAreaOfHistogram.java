import java.util.Stack;

public class MaxAreaOfHistogram {
    public static void main(String[] args) {
        int[] height = {2,1,5,6,2,3};
        int[] minLeft = new int[height.length];
        int[] minRight = new int[height.length];
        Stack<Integer> stack = new Stack<>();

        // Findin the MinRight for each and every element
        for(int i=height.length-1; i>=0; i--){
            if(stack.isEmpty()){
                minRight[i] = height.length;
            }else{
                if(height[stack.peek()] < height[i]){
                    minRight[i] = stack.peek();
                }else{
                    while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                        minRight[i] = height.length;
                    }else{
                        minRight[i] = stack.peek();
                    }
                }
            }
            stack.push(i);
        }

        // Findin the MinLeft for each and every element
        stack.clear();
        for(int i=0; i<height.length; i++){
            if(stack.isEmpty()){
                minLeft[i] = -1;
            }else{
                if(height[stack.peek()] < height[i]){
                    minLeft[i] = stack.peek();
                }else{
                    while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                        minLeft[i] = -1;
                    }else{
                        minLeft[i] = stack.peek();
                    }
                }
            }
            stack.push(i);
        }

        int maxArea = 0;
        for(int i=0; i<height.length; i++){
            maxArea = Math.max(maxArea, height[i]*(minRight[i] - minLeft[i] - 1));
        }
        System.out.println(maxArea);
    } 
}
