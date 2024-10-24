import java.util.Stack;

public class StockSpan {

    static int count;
    public static void findNumber(Stack<Integer> stack, int data){
        if(stack.isEmpty()){
            return;
        }
        if(data >= stack.peek()){
            count++;
            int temp = stack.pop();
            findNumber(stack, data);
            stack.push(temp);
        }else{
            return;
        }
    }

    public static void StockSpanStack(Stack<Integer> stack, int[] array, int index){
        if(index == array.length){
            return;
        }
        stack.push(array[index]);
        count = 0;
        findNumber(stack, array[index]);
        System.out.print(count + " ");
        StockSpanStack(stack, array, index+1);
    }

    public static void stockSpanOn(int[] array, Stack<Integer> stack, int index){
        if(index == array.length){
            return;
        }
        if(stack.isEmpty()){
            stack.push(index);
            System.out.print(1 + " ");
        }else{
            while (!stack.isEmpty() && array[index] >= array[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()){
                System.out.print((index + 1) + " ");
            }else{
                System.out.print((index - stack.peek()) + " ");
            }
            stack.push(index);
        }
        stockSpanOn(array, stack, index+1);
    }
    public static void main(String[] args) {
        int[] array = {100,80,60,70,60,85,100};
        Stack<Integer> stack = new Stack<>();
        // O(n^2) Approach
        // StockSpanStack(stack,array,0);

        // O(n) Approach
        // Main Formula is stockspan(i) = i - previousHigh (previoushigh is the element's index greater than data in i'th index);
        stockSpanOn(array, stack, 0);
    }
}
