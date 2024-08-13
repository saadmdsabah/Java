package Deque;

import java.util.Deque;
import java.util.LinkedList;

public class QueueUsingDeque {

    public static class QueueDeque {
        public Deque<Integer> deque = new LinkedList<>();
        
        public void push(int val){
            deque.add(val);
        }

        public int remove(){
            return deque.isEmpty() ? -1 : deque.removeFirst();
        }

        public int peek(){
            return deque.isEmpty() ? -1 : deque.peekFirst();
        }
    }
    public static void main(String[] args) {
        QueueDeque queue = new QueueDeque();
        queue.push(0);
        queue.push(1);
        queue.push(3);
        System.out.println(queue.peek());

        queue.remove();
        System.out.println(queue.peek());
    }
}
