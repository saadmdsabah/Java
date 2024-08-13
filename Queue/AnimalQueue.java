package Queue;

public class AnimalQueue {
    
static class Node{
    String val;
    Node next;
    Node prev;
    Node(String val){
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
    static Node first = null;
    static Node last = null;
    static Node dog_first = null;
    static Node cat_first = null;
    static Node dog_last = null;
    static Node cat_last = null;

    public static void push(String type, String name){
        Node newNode = new Node(name);
        if(first == null){
            first = newNode;
            last = newNode;
            Node d_c = new Node(name);
            if(type.toLowerCase().equals("dog")){
                dog_first = d_c;
                dog_last = d_c;
            }else{
                cat_first = d_c;
                cat_last = d_c;
            }
        }
        else{
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
            Node d_c = new Node(name);
            if(type.toLowerCase().equals("dog")){
                if(dog_first == null){
                    dog_first = d_c;
                    dog_last = d_c;
                }else{
                    dog_last.next = d_c;
                    d_c.prev = dog_last;
                    dog_last = d_c;
                }

            }else{
                if(cat_first == null){
                    cat_first = d_c;
                    cat_last = d_c;
                }else{
                    cat_last.next = d_c;
                    d_c.prev = cat_last;
                    cat_last = d_c;
                }
            }
        }
        System.out.println(name + " Has been pushed");
    }

    public static void pop(){
        if(first == null){
            System.out.println("The Queue is Empty so Element cannot be poped");
            return;
        }
        
        if(first.val.equals(dog_first.val)){
            if(dog_first != null){
                dog_first = dog_first.next;
            }
        }else{
            if(cat_first != null){
                cat_first = cat_first.next;
            }
        }
        first = first.next;
    }

    public static void isEmpty(){
        if(first == null){
            System.out.println(true);
            return;
        }
        System.out.println(false);
    }

    public static void traverseQueue(){
        if(first == null){
            System.out.println("The Queue is Empty cannot traverse througt it");
            return;
        }
        Node temp = first;
        while (temp.next!=null) {
            System.out.print(temp.val + " | ");
            temp = temp.next;
        }
        System.out.println(temp.val);
    }

    public static void getDog(){
        if(dog_first == null){
            System.out.println("Dog Queue is Empty hence cannot get the name");
            return;
        }
        System.out.println("The name of the dog is "+ dog_first.val);
    }

    public static void getCat(){
        if(cat_first == null){
            System.out.println("Cat Queue is Empty hence cannot get the name");
            return;
        }
        System.out.println("The name of the cat is "+ cat_first.val);
    }
    
    public static void main(String[] args) {
        push("cat", "hans");
        push("cat", "pick");
        push("dog", "hog");

        getDog();
        getCat();
        pop();

        traverseQueue();
        getDog();
        getCat();
        pop();
        traverseQueue();
        getCat();
    }
}
