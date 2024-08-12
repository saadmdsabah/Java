public class Linked_list_inbuilt {
    Node head;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
        }
        else{
            Node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
    }
    public void printList(){
        if(head==null) System.out.println("List is Empty");
        else{
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.data + " --> ");
                temp = temp.next;
            }
            System.out.println("NULL");
        }
    }
    public int listSize(){
        if(head==null) return 0;
        int count = 0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            count += 1;
        }
        return count;
    }
    public int nthNode(int r){
        if(head==null) return -1;
        int length = listSize();
        int count = length-r;
        if(count < 0 || count > length) return -1;
        Node temp = head;
        for(int i=0;i<count;i++){
            temp = temp.next;
        }
        return temp.data;
    }
    public boolean isPalindrom(){
        String d1 = "";
        String d2 = "";
        if(head==null) return false;
        else{
            Node temp = head;
            while(temp!=null){
                d1 = d1 + temp.data;
                d2 = temp.data + d2;
                temp = temp.next;
            }
        }
        return d1.equals(d2);
    }
    public static void main(String[] args){
        Linked_list_inbuilt list = new Linked_list_inbuilt();
        list.addFirst(1);
        list.addFirst(1);
        list.addFirst(0);
        list.addFirst(0);
        list.addFirst(1);
        list.printList();
        System.out.println(list.isPalindrom());
    }
}