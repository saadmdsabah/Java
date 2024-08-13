package Queue;

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

public class QueueUsingLinkedList {

    static Node first = null;
    static Node last = null;

    public static void push(int data){
        Node newNode = new Node(data);
        if(first == null){
            first = newNode;
            last = newNode;
            System.out.println(data + " is Pushed");
            return;
        }
        last.next = newNode;
        newNode.prev = last;
        last = newNode;
        System.out.println(data + " is Pushed");
    }

    public static void pop(){
        if(first == null){
            System.out.println("The Queue is empty cannot pop element");
            return;
        }
        System.out.println("The Poped element is " + first.val);
        first = first.next;
    }

    public static void traverseQueue(){
        if(first == null){
            System.out.println("The Queue is Empty Cannot traverse through it");
            return;
        }
        Node temp = first;
        while (temp.next!=null) {
            System.out.print(temp.val + " | ");
            temp = temp.next;
        }
        System.out.print(temp.val);
    }

    public static void isEmpty(){
        if(first == null){
            System.out.println(true);
            return;
        }
        System.out.println(false);
    }
    public static void main(String[] args) {
        push(10);
        push(4);
        push(2);
        push(-2);

        traverseQueue();
        pop();
        traverseQueue();
    }
}
