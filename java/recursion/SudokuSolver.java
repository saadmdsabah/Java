public class SudokuSolver {

    public static void printboard(int[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean gridSearch(int[][] board,int row,int col,int number){
        for(int r=row;r<row+3;r++){
            for(int c=col;c<col+3;c++){
                if(board[r][c] == number){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean validNumber(int[][] board, int row, int col, int number) {
        // Check for row
        for(int i=0;i<board.length;i++){
            if(board[row][i] == number){
                return false;
            }
        }

        // Check for column
        for(int i=0;i<board.length;i++){
            if(board[i][col] == number){
                return false;
            }
        }

        // for the grid ;)
        int gridno_x = (int)row/3;
        int gridno_y = (int)col/3;
        return gridSearch(board, gridno_x*3, gridno_y*3,number);
    }

    public static void sudokuSolver(int[][] board, int row, int col){
        if(row == board.length) {
            printboard(board);
            return;
        }
        
        //  Next row,col
        int nrow = 0;
        int ncol = 0;
        if(col == board.length-1) {
            nrow = row + 1;
            ncol = 0;
        } else {
            nrow = row;
            ncol = col + 1;
        }
        
        // fill board
        if(board[row][col] != 0) {
            sudokuSolver(board, nrow, ncol);
        } else {
            for(int i=1; i<=9; i++) {
                if(validNumber(board, row, col, i)) {
                    board[row][col] = i;
                    sudokuSolver(board, nrow, ncol);
                    board[row][col] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = 
        { 
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0} 
        };
        sudokuSolver(board, 0, 0);
    }
}
