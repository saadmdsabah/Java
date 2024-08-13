package Heaps.PriorityQueue;

import java.util.PriorityQueue;

public class pqWithObjects {

    static class student implements Comparable<student> {
        String name;
        int rank;
        public student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(student s2){
            return this.rank - s2.rank;
        }
    }
    
    public static void main(String[] args) {
        PriorityQueue<student> pq = new PriorityQueue<>();
        pq.add(new student("Saad", 10));
        pq.add(new student("Hamzah", 1));
        pq.add(new student("Owais", 4));
        pq.add(new student("Sohaib", 3));
        pq.add(new student("Abraar", 0));


        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + " -> " +pq.peek().rank);
            pq.remove();
        }
        

    }
}
