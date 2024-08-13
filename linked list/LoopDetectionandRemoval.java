public class LoopDetectionandRemoval {
    public static class Node {
        int val;
        Node next;
        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);


        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        
        Node slow = first;
        Node fast = first;
        boolean present = false;

        // Loop Detection
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                present = true;
                break;
            }
        }
        // Loop Removal
        if(present){
            slow = first;
            Node prev = null;
            while (slow != fast) {
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }
            prev.next = null;   

            Node temp = first;
            while (temp!=null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
        }else{
            System.out.println("No Loop Detected");
        }
    }
}
