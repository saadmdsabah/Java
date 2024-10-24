import java.util.Stack;

public class PushAtTheBottom {

    public static void pushAtBottom(Stack<Integer> stack, int data){
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }
        int temp = stack.peek();
        stack.pop();
        pushAtBottom(stack, data);
        stack.push(temp);
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        pushAtBottom(stack, 0);
        pushAtBottom(stack, 1);
        pushAtBottom(stack, 2);
        pushAtBottom(stack, 3);
        System.out.println(stack);
        System.out.println(stack.peek());
    }
}
