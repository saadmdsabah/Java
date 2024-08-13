public class tileplace {

    public static int placeTiles(int n, int m){
        if(n == m){
            return 2;
        }
        if(n<m){
            return 1;
        }
        int vertical = placeTiles(n-m, m);
        int horizontal = placeTiles(n-1, m);
        return vertical + horizontal;
    }
    public static void main(String[] args) {
        System.out.println(placeTiles(4, 2));
    }
}
