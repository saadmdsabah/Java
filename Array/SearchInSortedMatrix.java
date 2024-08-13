package Array;

public class SearchInSortedMatrix {

    public static int BinarySearch(int[][] matrix, int columnStart, int rowStart, int rowCol, int key){
        if(rowCol == 0){ //Means Row
            int first = columnStart;
            int last = matrix[0].length-1;
            while (first<=last) {
                int mid = (last-first)/2 + first;
                if(matrix[rowStart][mid] == key){
                    return mid;
                }else if(matrix[rowStart][mid] > key){
                    last = mid-1;
                }else{
                    first = mid + 1;
                }
            }
        }else{ // Means Column
            int first = rowStart;
            int last = matrix.length-1;
            while (first<=last) {
                int mid = (last-first)/2 + first;
                if(matrix[mid][columnStart] == key){
                    return mid;
                }else if(matrix[mid][columnStart] > key){
                    last = mid-1;
                }else{
                    first = mid + 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] matrix = {{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
        int rs = 0, cs = 0;
        int key = 33;

        // Approach 1:
        // while (rs<matrix.length && cs<matrix[0].length) {
        //     if(matrix[rs][cs] == key){
        //         System.out.println("Index: row " + rs +", column " + cs);
        //         return;
        //     }
        //     if(matrix[rs][matrix[0].length-1] == key){
        //         System.out.println("Index: row " + rs +", column " + (matrix[0].length-1));
        //         return;
        //     }
        //     if(matrix[matrix.length-1][cs] == key){
        //         System.out.println("Index: row " + (matrix.length-1) +", column " + cs);
        //         return;
        //     }
        //     if(matrix[rs][cs] < key && matrix[rs][matrix[0].length-1] > key){
        //         int temp = BinarySearch(matrix,cs,rs,0,key);
        //         if(temp != -1){
        //             System.out.println("Index: row " + rs +", column " + temp);
        //             return;
        //         }
        //     }
        //     if(matrix[rs][cs] < key && matrix[matrix.length-1][cs] > key){
        //         int temp = BinarySearch(matrix,cs,rs,1,key);
        //         if(temp != -1){
        //             System.out.println("Index: row " + temp +", column " + cs);
        //             return;
        //         }
        //     }
        //     rs++;cs++;
        // }
        // System.out.println("The Key Doesn't Exist");

        // Approach 2: Stearcase Method
        rs = 0; cs = matrix[0].length-1;
        if(matrix[matrix.length-1][0] == key){
            System.out.println("Index: row " + (matrix.length-1) +", column " + 0);
            return;
        }
        while (cs >= 0 && rs <= matrix.length-1) {
            if(matrix[rs][cs] == key){
                System.out.println("Index: row " + rs +", column " + cs);
                return;
            }else if(key > matrix[rs][cs]){
                rs++;
            }else{
                cs--;
            }
        }
        System.out.println("The Key Doesn't Exist");
    }
}
