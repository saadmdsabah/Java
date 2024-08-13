package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueReversal {

    public static void reverseQueue(Queue<Integer> queue){
        if(queue.isEmpty()){
            return;
        }
        int top = queue.remove();
        reverseQueue(queue);
        queue.add(top);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Queue<Integer> queue = new LinkedList<>();
        for(int i : arr){
            queue.add(i);
        }
        System.out.println(queue);
        reverseQueue(queue);
        System.out.println(queue);
    }
}
