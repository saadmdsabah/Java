package Searching;

public class LinearSearch {
    public static void main(String[] args) {
        int array[] = {1,2,3,6,2,6,9,10};
        int target = 6;
        for(int i=0; i<array.length; i++){
            if(array[i] == target){
                System.out.println(target+" is present at the index " + i);
                return;
            }
        }
        System.out.println("The Number doesn't Exist");
    }
}
