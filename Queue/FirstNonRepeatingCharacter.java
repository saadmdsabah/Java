package Queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String s = "aabccxb";
        HashSet<Character> set = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();

        // My Approach O(n^2)
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!set.contains(ch)){
                set.add(ch);
                queue.add(ch);
            }else{
                queue.remove(ch);
            }
            if(queue.isEmpty()) System.out.println(-1);
            else System.out.println(queue.peek());
        }

        // Apna College Approach O(n^2)
        int[] freq = new int[26];
        queue.clear();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            freq[ch - 'a']++;
            queue.add(ch);
            while (!queue.isEmpty() && freq[queue.peek() - 'a'] > 1) {
                queue.remove();
            }
            if(queue.isEmpty()) System.out.println(-1);
            else System.out.println(queue.peek());
        }
    }
}
