import java.util.ArrayList;
import java.util.Stack;

public class StackFromArraylist {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        ArrayList<Integer> list = new ArrayList<>();

        while(!s.isEmpty()){
            System.out.println(s.peek());
            list.add(s.peek());
            s.pop();
        }
        s.push(1);
        for(int i=list.size()-1;i>=0;i--){
            s.push(list.get(i));
        }
        System.out.println();
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }


    }
}
