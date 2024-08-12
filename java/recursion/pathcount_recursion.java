public class pathcount_recursion {

    public static int count = 0;

    public static void maze(int n,int m,int right,int down){
        if(right == m-1 && down == n-1){
            count += 1;
            return;
        }
        if(right + 1 <= m-1){
            maze(n, m, right+1, down);
        }
        if(down + 1 <= n-1){
            maze(n, m, right, down+1);
        }
    }
    public static void main(String[] args) {
        maze(4, 4, 0, 0);
        System.out.println(count);
    }
}
