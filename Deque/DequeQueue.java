package Deque;

import java.util.Deque;
import java.util.LinkedList;

public class DequeQueue {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(2);
        deque.add(3);
        deque.addFirst(4);
        deque.add(5);
        System.out.println(deque);
        
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());

        deque.removeFirst();
        deque.removeLast();
        System.out.println(deque);
    }
}
