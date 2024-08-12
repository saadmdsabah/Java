package Queue;

import java.util.Stack;

public class QueueUsingStack {
    static Stack<Integer> temp = new Stack<>();
    static Stack<Integer> stack = new Stack<>();

    public static void push(int data){
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }
        while (!stack.isEmpty()) {
            int t = stack.peek();
            temp.push(t);
            stack.pop();
        }
        stack.push(data);
        while (!temp.isEmpty()) {
            int t = temp.peek();
            stack.push(t);
            temp.pop();
        }
    }

    public static void pop(){
        if(stack.isEmpty()){
            System.out.println("The stack is Empty");
            return;
        }
        System.out.println("The poped element is " + stack.peek());
        stack.pop();
    }

    public static void isEmpty(){
        System.out.println(stack.isEmpty());
    }
    public static void main(String[] args) {
        push(0);
        push(1);
        push(3);
        pop();
        pop();
        pop();
        pop();
    }
}
