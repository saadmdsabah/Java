import java.util.ArrayList;
import java.util.Arrays;

public class StackOfPlates {
    static ArrayList<ArrayList<Integer>> stack = new ArrayList<>();
    static int thershold = 5;

    public static void push(int data){
        if(stack.size() == 0){
            stack.add(new ArrayList<>(Arrays.asList(data)));
            System.out.println("The Pushed Element is " + data);
            return;
        }
        if(stack.get(stack.size()-1).size() == thershold){
            stack.add(new ArrayList<>(Arrays.asList(data)));
            System.out.println("The Pushed Element is " + data);
            return;
        }
        stack.get(stack.size()-1).add(data);
        System.out.println("The Pushed Element is " + data);
    }

    public static void pop(){
        if(stack.size() == 0){
            System.out.println("The Stack is Empty cannot pop element");
            return;
        }
        if(stack.get(stack.size() - 1).size() == 1){
            System.out.println("The poped element is " + stack.get(stack.size()-1).get(0));
            stack.remove(stack.size() - 1);
            return;
        }
        int data = stack.get(stack.size() - 1).remove(stack.get(stack.size()-1).size() - 1);
        System.out.println("The poped element is " + data);
    }

    public static void popAt(int index){
        if(stack.size() == 0){
            System.out.println("The Stack is Empty cannot pop element");
            return;
        }
        int i = index/5;
        if(i > stack.size()){
            System.out.println("The element you are trying to pop doesn't Exist");
            return;
        }else{
            if(stack.get(i).size() < index - i*5 + 1){
                System.out.println("The element you are trying to pop doesn't Exist");
                return;
            }else{
                System.out.println("The poped element is " + stack.get(i).get(index - i*5));
                stack.get(i).remove(index - i*5);
                if(stack.get(i).size() == 0){
                    stack.remove(i);
                } 
            }
        }
    }

    public static void isEmpty(){
        if(stack.size() == 0){
            System.out.println(true);
            return;
        }
        System.out.println(false);
    }

    public static void printStack(){
        System.out.println(stack);
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        push(4);
        push(5);
        push(3);
        push(4);
        push(5);
        push(6);
        push(7);
        push(1);
        push(4);
        printStack();
        popAt(11);
        popAt(10);
        printStack();
    }   
}
