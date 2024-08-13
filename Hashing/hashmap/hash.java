import java.util.*;
public class hash {
    public static void main(String[] args) {
        int[] array = {15,-2,2,-8,1,7,10};
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int length = 0;

        for(int i=0; i<array.length; i++){
            sum+=array[i];
            if(map.containsKey(sum)){
                length = Math.max(length, i-map.get(sum));
            }else{
                map.put(sum, i);
            }
        }
        System.out.println(length);
    }
}
