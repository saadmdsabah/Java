package Heaps.PriorityQueue;
import java.util.PriorityQueue;

public class KnearestCars {

    public static class Knearest implements Comparable<Knearest>{
        int number;
        int x;
        int y;
        int dist;
        public Knearest(int number,int x, int y){
            this.number = number;
            this.x = x;
            this.y = y;
            this.dist = x*x + y*y;
        }

        @Override
        public int compareTo(Knearest car2){
            return this.dist - car2.dist; 
        }
    }
    public static void main(String[] args) {
        int[][] input = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        // Method 1:
        PriorityQueue<Knearest> pq = new PriorityQueue<>();
        for(int i=0; i<input.length; i++){
            pq.add(new Knearest(i, input[i][0], input[i][1]));
        }
        for(int i=0; i<k; i++){
            System.out.println(pq.remove().number);
        }

        // Method 2:
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int i=0;i<input.length;i++){
        //     int temp = input[i][0]*input[i][0] + input[i][1]*input[i][1];
        //     pq.add(temp);
        //     map.put(temp, i);
        // }
        // while (!pq.isEmpty() && k>0) {
        //     System.out.println(map.get(pq.remove()));
        //     k--;
        // }
    }
}
