public class ReverseDoubleLinkedList {

    public static class Node {
        int val;
        Node next;
        Node prev;
        public Node(int val){
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
    public static void main(String[] args) {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        first.next = second;
        second.prev = first;
        second.next = third;
        third.prev = second;
        third.next = fourth;
        fourth.prev = third;

        Node prev = null;
        Node current = first;
        Node next;

        while (current!=null) {
            next = current.next;
            current.next = prev;
            current.prev = next;
            prev = current;
            current = next;
        }
    }
}
