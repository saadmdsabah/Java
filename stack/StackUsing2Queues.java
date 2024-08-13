import java.util.Queue;
import java.util.LinkedList;

public class StackUsing2Queues {

    public static class StackUsingQueue {
        static Queue<Integer> queue = new LinkedList<>();
        static Queue<Integer> temp = new LinkedList<>();

        public void push(int value){
            queue.add(value);
        }

        public int pop(){
            while (queue.size() != 1) {
                int t = queue.remove();
                temp.add(t);
            }
            int result = queue.remove();
            while (!temp.isEmpty()) {
                int t = temp.remove();
                queue.add(t);
            }
            return result;
        }

        public boolean isEmpty(){
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        StackUsingQueue s = new StackUsingQueue();
        s.push(0);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(6);

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
}
