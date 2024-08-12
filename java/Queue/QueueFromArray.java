package Queue;

public class QueueFromArray {

    static int[] queue = new int[10];
    static int n = queue.length-1;
    static int first = -1;
    static int last = -1;

    public static void push(int data){
        if(last == -1){
            first += 1;
            last += 1;
            queue[last] = data;
            System.out.println("Pushed element " + data);
            return;
        }else if(last == n-1){
            System.out.println("The Queue is Full cannot add element");
            return;
        }
        last += 1;
        queue[last] = data;
        System.out.println("Pushed element " + data);
    }

    public static void remove(){
        if(first == -1){
            System.out.println("The Queue is Empty cannot remove element from it");
            return;
        }
        else if(first == last){
            System.out.println("The element removed is " + queue[first]);
            first = -1;
            last = -1;
            return;
        }
        System.out.println("The element removed is " + queue[first]);
        first += 1;
    }

    public static void top(){
        if(first == -1){
            System.out.println("The Queue is Empty doesn't have a top element");
            return;
        }
        System.out.println("The top of the Queue is " + queue[first]);
    }

    public static void isEmpty(){
        if(last == -1){
            System.out.println(true);
            return;
        }
        System.out.println(false);
    }

    public static void isFull(){
        if(last == n-1){
            System.out.println(true);
            return;
        }
        System.out.println(false);
    }

    public static void main(String[] args) {
        push(10);
        top();
        remove();
        top();
        isEmpty();
        isFull();
    }
}