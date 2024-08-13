import java.util.Arrays;
import java.util.Scanner;

public class NQueens {

    public static boolean interact(char[][] board, int i, int j){

        // Vertical check
        for(int k=0;k<board.length;k++){
            if(board[k][j] == 'Q'){
                return false;
            }
        }

        // Upper Left Diagonal check
        int temp_i = i;
        int temp_j = j;
        while (temp_i >=0 && temp_j >=0) {
            if (board[temp_i][temp_j] == 'Q') {
                return false;
            }
            temp_i -= 1;
            temp_j -= 1;
        }

        // Upper Right diagonal check
        while (i >= 0 && j < board.length) {
            if(board[i][j] == 'Q'){
                return false;
            }
            i -= 1;
            j += 1;
        }

        // No interaction 
        return true;
    }

    public static void printBoard(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void nQueens(char[][] board, int currRow){
        if(currRow >= board.length){
            printBoard(board);
            return;
        }
        for(int i=0;i<board.length;i++){
            if(interact(board, currRow, i)){
                board[currRow][i] = 'Q';
                nQueens(board, currRow+1);
                board[currRow][i] = '_';
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter dimension of the matrix : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        char[][] board = new char[n][n];
        
        for(char[] arr : board){
            Arrays.fill(arr, '_');
        }
        nQueens(board, 0);
    }
}
