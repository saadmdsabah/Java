package Deque;

import java.util.Deque;
import java.util.LinkedList;

public class StackUsingDeque {

    public static class StackDeque {
        public Deque<Integer> deque = new LinkedList<>();

        public void push(int val){
            deque.add(val);
        }

        public int pop(){
            return deque.isEmpty() ? -1 : deque.removeLast();
        }

        public int peek(){
            return deque.isEmpty() ? -1 : deque.peekLast();
        }
    }
    public static void main(String[] args) {
        StackDeque stack = new StackDeque();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
