

public class StackFromArray {
    static int n = 10;
    static int[] arr = new int[n];
    static int first = -1;
    static int last = -1;

    public static void push(int data){
        if(last == -1){
            first += 1;
            last += 1;
            arr[first] = data;
            return;
        }
        if(last == n-1){
            System.out.println("The Stack is Full");
            return;
        }
        last = last + 1;
        arr[last] = data;
    }

    public static void pop(){
        if(last == -1){
            System.out.println("Cannot pop the Stack is Empty");
            return;
        }
        if(last == 0){
            System.out.println("The poped element is " + arr[last]);
            last = -1;
            first = -1;
            return;
        }
        System.out.println("The poped element is " + arr[last]);
        last -= 1;
    }

    public static void top(){
        if(last == -1){
            System.out.println("The Stack is Empty");
            return;
        }
        System.out.println("The top of the stack is " + arr[last]);
    }

    public static void isEmpty(){
        if(first == -1){
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
        push(20);
        push(30);
        push(2);

        top();
        pop();
        top();
        pop();
        top();
        pop();
        top();
        pop();
        isEmpty();
        isFull();

    }
}
