package Heaps;

import java.util.ArrayList;

public class heaps {
    
    static class minHeap {
        ArrayList<Integer> arr = new ArrayList<>();
        
        public void insert(int value){
            arr.add(value);
            int x = arr.size()-1;
            int parent = (x-1)/2;
            while (arr.get(x) < arr.get(parent)) {
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);

                x = parent;
                parent = (x-1)/2;
            }
        }

        public int peek(){
            return arr.get(0);
        }

        private void Heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int minInx = i;
            if(left < arr.size() && arr.get(minInx) > arr.get(left)){
                minInx = left;
            }
            if(right < arr.size() && arr.get(minInx) > arr.get(right)){
                minInx = right;
            }

            if(minInx!=i){
                int temp = arr.get(minInx);
                arr.set(minInx, arr.get(i));
                arr.set(i, temp);

                Heapify(minInx);
            }   
        }

        public int remove(){
            int data = arr.get(0);

            // Step - 1 swap last and the first position in the Heaps tree
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            // Step - 2 Remove the last element of the heap
            arr.remove(arr.size() - 1);

            // step - 3 Heapify the heap
            Heapify(0);
            return data;
        }
    }

    static class maxHeap {
        ArrayList<Integer> arr = new ArrayList<>();
        
        public void insert(int value){
            arr.add(value);
            int x = arr.size()-1;
            int parent = (x-1)/2;
            while (arr.get(x) > arr.get(parent)) {
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);

                x = parent;
                parent = (x-1)/2;
            }
        }

        public int peek(){
            return arr.get(0);
        }

        private void Heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int maxInx = i;
            if(left < arr.size() && arr.get(maxInx) < arr.get(left)){
                maxInx = left;
            }
            if(right < arr.size() && arr.get(maxInx) < arr.get(right)){
                maxInx = right;
            }

            if(maxInx!=i){
                int temp = arr.get(maxInx);
                arr.set(maxInx, arr.get(i));
                arr.set(i, temp);

                Heapify(maxInx);
            }   
        }

        public int remove(){
            int data = arr.get(0);

            // Step - 1 swap last and the first position in the Heaps tree
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            // Step - 2 Remove the last element of the heap
            arr.remove(arr.size() - 1);

            // step - 3 Heapify the heap
            Heapify(0);
            return data;
        }
    }
    public static void main(String[] args) {
        minHeap hp = new minHeap();
        hp.insert(2);
        hp.insert(5);
        hp.insert(3);
        hp.insert(1);
        hp.insert(6);
        System.out.println(hp.arr);

        while (!hp.arr.isEmpty()) {
            System.out.print(hp.peek() + " ");
            hp.remove();
        }
        System.out.println();
        maxHeap h = new maxHeap();
        h.insert(2);
        h.insert(5);
        h.insert(3);
        h.insert(1);
        h.insert(6);
        System.out.println(h.arr);

        while (!h.arr.isEmpty()) {
            System.out.print(h.peek() + " ");
            h.remove();
        }

        
    }   
}
