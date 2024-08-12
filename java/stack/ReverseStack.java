import java.util.Stack;

public class ReverseStack {

    public static void addAtBottom(Stack<Integer> stack, int temp){
        if(stack.isEmpty()){
            stack.push(temp);
            return;
        }
        int data = stack.pop();
        addAtBottom(stack, temp);
        stack.push(data);
    }

    public static void reverseStackRec(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int temp = stack.pop();
        reverseStackRec(stack);
        addAtBottom(stack,temp);
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);

        reverseStackRec(stack);

        System.out.println(stack);


    }
}
