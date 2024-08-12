package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Interleave2Halves {

    public static class Node {
        int val;
        Node next;
        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static class QueueLinkedList {
        public Node head = null;
        public Node tail = null;

        public void add(int val){
            Node newNode = new Node(val);
            if(tail == null){
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        public Node middle(Node temp){
            Node slow = head;
            Node fast = head;
            while (fast != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        public void printSeq(Node first, Node middle){
            while (middle!=null) {
                System.out.print(first.val + " ");
                System.out.print(middle.val + " ");
                first = first.next;
                middle = middle.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // My Approach
        int[] input = {1,2,3,4,5,6,7,8,9,10};
        QueueLinkedList queue = new QueueLinkedList();
        for(int i : input){
            queue.add(i);
        }
        Node head = queue.head;
        Node middle = queue.middle(head);
        queue.printSeq(head, middle);

        // Apna College Approach
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i : input){
            q1.add(i);
        }
        int s = q1.size()/2;
        for(int i=0; i<s; i++){
            q2.add(q1.remove());
        }
        while (!q2.isEmpty()) {
            q1.add(q2.remove());
            q1.add(q1.remove());
        }
        System.out.println(q1);
    }
}
