public class ZigZig {
    public static class Node {
        int val;
        Node next;
        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static Node middleOFList(Node first){
        Node slow = first;
        Node fast = first;

        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node reverseList(Node middle){
        Node prev = null;
        Node current = middle;
        Node next = current.next;

        while (next!=null) {
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }
        current.next = prev;
        return current;
    }
    public static void main(String[] args) {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);


        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;

        Node middle = middleOFList(first);
        Node last = reverseList(middle);

        Node temp = null;
        Node t = first;
        while (first != last) {
            temp = first.next;
            first.next = last;
            first = temp;
            if(first == last){
                break;
            }
            temp = last.next;
            last.next = first;
            last = temp;
        }

        while (t!=null) {
            System.out.print(t.val + " ");
            t = t.next;
        }

    }
}
