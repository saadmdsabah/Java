public class ProductOfArray {

    public static int productofArray(int A[], int N) { 
        if(N == 0){
            return A[0];
        }
        return A[N]*productofArray(A, N-1);
    } 
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        System.out.println(productofArray(A, A.length-1));
    }
}
