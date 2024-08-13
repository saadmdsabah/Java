public class Linked_List_from_Scratch {
    static Node head;
    class Node{
        String data;
        Node next;
        Node(String data){
            this.data = data;
            this.next = null;
        }
    }
    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next!=null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void printList(){
        if(head==null){
            System.out.println("List Is Empty :|");
            return;
        }
        Node currNode = head;
        while(currNode!=null){
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    public void lastDelete(){
        if(head == null){
            System.out.println("List is Empty cannot delete element.");
            return;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }

    public void firstDelete(){
        if(head == null){
            System.out.println("List is Empty cannot delete element.");
            return;
        }
        head = head.next;
    }

    public void middleDelete(String data){
        if(head == null){
            System.out.println("List is Empty cannot delete element.");
            return;
        }
        Node temp = head;
        while(temp.data != data){
            temp = temp.next;
            if(temp.next == null){
                System.out.println("Element Not Present :|");
                return;
            }
        }
        temp.next = temp.next.next;
    }
    public int size(){
        if(head == null){
            return 0;
        }
        int count = 1;
        Node temp = head;
        while(temp.next!=null){
            count +=1;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Linked_List_from_Scratch list = new Linked_List_from_Scratch();
        list.addFirst("S");
        list.addLast("A");
        list.addLast("A");
        list.addLast("D");
        list.printList();
        
        //                                         reverse a List
        Node ptr1 = head;
        Node ptr2 = head;
        Node prev = null;

        while(ptr1 != null){
            ptr1 = ptr1.next;
            ptr2.next = prev;
            prev = ptr2;
            ptr2 = ptr1;
        }
        System.out.println(prev.data);
        head = prev;
        list.printList();
    }
}