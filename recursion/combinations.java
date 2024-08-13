import java.util.ArrayList;
import java.util.Arrays;

public class combinations {
    public static void permutation(int[] arr, int n,boolean[] t_f,ArrayList<Integer> list){
        if(list.size() == 3){
            System.out.println(list);
            return;
        }
        for(int i=0;i<n;i++){
            if(!t_f[i]){
                t_f[i] = true;
                list.add(arr[i]);
                permutation(arr, n, t_f, list);
                t_f[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        boolean[] t_f = new boolean[arr.length];
        Arrays.fill(t_f,false);
        ArrayList<Integer> list = new ArrayList<>();
        permutation(arr,arr.length,t_f,list);
    }
}
