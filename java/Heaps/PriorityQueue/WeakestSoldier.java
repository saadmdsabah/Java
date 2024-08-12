package Heaps.PriorityQueue;

import java.util.PriorityQueue;

public class WeakestSoldier {

    public static class Soldier implements Comparable<Soldier>{
        int index;
        int noOfSldiers;
        public Soldier(int index, int noOfSldiers){
            this.index = index;
            this.noOfSldiers = noOfSldiers;
        }

        @Override
        public int compareTo(Soldier s2){
            if(this.noOfSldiers == s2.noOfSldiers){
                return this.index - s2.index;
            }
            return this.noOfSldiers - s2.noOfSldiers;
        }
    }
    public static void main(String[] args) {
        int[][] ground = {{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int k = 2;
        PriorityQueue<Soldier> pq = new PriorityQueue<>();
        for(int i=0; i<ground.length ;i++){
            int number = ground[i][0] + ground[i][1] + ground[i][2] + ground[i][3];
            pq.add(new Soldier(i,number));
        }
        while (!pq.isEmpty() && k>0) {
            System.out.println(pq.remove().index);k--;
        }
    }   
}
