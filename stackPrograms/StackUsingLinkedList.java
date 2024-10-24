public class StackUsingLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static class Stack{
        public static Node head;
        public static boolean isEmpty(){
            return head == null;
        } 
        public void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode; 
                return;
            }
            newNode.next = head;
            head = newNode;
        }
        public int pop(){
            if(head == null) return -1;
            int top = head.data;
            head = head.next;
            return top;
        }
        public static int peek(){
            if(head == null) return -1;
            return head.data;
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());

    }
}
