import java.util.HashMap;
import java.util.Map;
public class HashMap_java {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        // inserting values in the hashmap
        map.put("Saad", 23);
        map.put("Hamzah", 23);
        map.put("Owais", 23);
        map.put("Saad", 22);
        System.out.println(map);

        // looking for the key in a hashmap
        System.out.println(map.containsKey("Saad"));

        // get the value of a particular key
        System.out.println(map.get("Saad"));
        System.out.println(map.get("Abraar"));

        // for loop for maps
        for(Map.Entry<String,Integer> e : map.entrySet()){
            System.out.println(e.getKey());
            System.out.println(e.getValue());

        }
        // removing element in a map
        map.remove("Saad");
        System.out.println(map);
        // set of keys in a map
        System.out.println(map.keySet());
    }
}
