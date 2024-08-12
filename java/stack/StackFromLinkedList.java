class Node{
    int val;
    Node next;
    Node prev;
    Node(int val){
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
public class StackFromLinkedList {
    static Node first = null;
    static Node last = null;

    public static void push(int data){
        Node newNode = new Node(data);
        if(last == null){
            last = newNode;
            first = newNode;
            return;
        }
        last.next = newNode;
        newNode.prev = last;
        last = newNode;
    }

    public static void pop(){
        if(last == null){
            System.out.println("The stack is Empty");
            return;
        }else if(first == last){
            System.out.println("The poped element is " + last.val);
            last = null;
            first = null;
            return;
        }
        System.out.println("The poped element is " + last.val);
        last = last.prev;
    }

    public static void isEmpty(){
        if(last == null){
            System.out.println(true);
            return;
        }
        System.out.println(false);
    }

    public static void printStack(){
        if(last == null){
            System.out.println("The Stack is Empty cannot traverse it");
            return;
        }
        Node temp = last;
        while (temp != first) {
            System.out.println("| " + temp.val + " |");
            temp = temp.prev;
        }
        System.out.println("| " + temp.val + " |");
    }

    public static void main(String[] args) {
        push(0);
        push(10);
        push(20);
        printStack();
        pop();
        printStack();
        isEmpty();
        pop();
        pop();
        printStack();
        isEmpty();
        push(0);
        printStack();
    }
}
