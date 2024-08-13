package String;

public class LargestString {
    public static void main(String[] args) {
        String fruits[] = {"apple","mango","banana"};
        String largest = fruits[0];

        for(int i=1; i<fruits.length; i++){
            largest = largest.compareToIgnoreCase(fruits[i]) < 0 ? fruits[i] : largest;
        }
        System.out.println(largest);
    }
}
