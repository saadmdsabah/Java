package Array;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int rs = 0, re = matrix.length-1, cs = 0, ce = matrix[0].length-1;
        while (rs <= re && cs <= ce) {
            for(int i=cs; i<=ce; i++){
                System.out.print(matrix[rs][i] + " ");
            }
            rs++;

            for(int i=rs; i<=re; i++){
                System.out.print(matrix[i][ce]+ " ");
            }
            ce--;

            for(int i=ce; i>=cs; i--){
                System.out.print(matrix[re][i]+ " ");
            }
            re--;

            for(int i=re; i>=rs; i--){
                System.out.print(matrix[i][cs] + " ");
            }
            cs++;
        }
    }
}
