import java.util.Arrays;
import java.util.LinkedList;

public class MergeSortForLinkedList {

    public static void Merge(LinkedList<Integer> list, int first, int mid, int last){
        int left = first;
        int right = mid+1;
        int[] array = new int[last - first + 1];
        int i = 0;

        while (left <= mid && right <= last) {
            if(list.get(left) < list.get(right)){
                array[i++] = list.get(left);
                left++;
            }else{
                array[i++] = list.get(right);
                right++;
            }
        }

        while (left <= mid) {
            array[i++] = list.get(left);
            left++;
        }

        while (right <= last) {
            array[i++] = list.get(right);
            right++;
        }

        for(int j=first; j<=last; j++){
            list.set(j, array[j-first]);
        }
    }

    public static void Divide(LinkedList<Integer> list, int first, int last){
        if(first == last){
            return;
        }
        int mid = (last-first)/2 + first;
        Divide(list, first, mid);
        Divide(list, mid+1, last);
        Merge(list, first, mid, last);
    }
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(5,4,3,2,1));
        System.out.println(list);
        Divide(list, 0,list.size()-1);
        System.out.println(list);
    }
}
