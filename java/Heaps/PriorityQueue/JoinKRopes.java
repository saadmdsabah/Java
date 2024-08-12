package Heaps.PriorityQueue;

import java.util.PriorityQueue;

public class JoinKRopes {
    public static void main(String[] args) {
        int[] ropes = {4,3,2,6};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : ropes){
            pq.add(i);
        }
        int sum = 0;
        if(pq.size() == 0){
            System.out.println(sum);
            return;
        }
        if(pq.size() == 1){
            sum += pq.remove();
            System.out.println(sum);
            return;
        }
        while (!pq.isEmpty()) {
            int temp = pq.remove() + pq.remove();
            sum += temp;
            if(pq.isEmpty()) break;
            else pq.add(temp);
        }
        System.out.println(sum);
    }
}
