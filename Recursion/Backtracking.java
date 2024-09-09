import java.util.ArrayList;
import java.util.Arrays;

public class Backtracking {
    public static void main(String[] args) {

        // char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        // if(sudokuSolver(board)){
        //     displaySudoku(board);
        // }else{
        //     System.out.println("Cannot solve sudoku");
        // }
        
        
    }
    static int countPath(int row,int col,int[][] arr){
        if(row == arr.length-1 || col == arr[0].length-1){
            if(row==arr.length-1 && col==arr[0].length-1){
                return 1;
            }else if(row==arr.length-1 && !(col==arr[0].length-1)){
                return countPath(row, col+1, arr);
            }else{
                return countPath(row+1, col, arr);
            }
        }

        int left = countPath(row+1, col, arr);
        int right = countPath(row, col+1, arr);

        return left+right;
    }
    static void printPath(String p,int row,int col,int[][] arr){
        if(row == arr.length-1 || col == arr[0].length-1){
            if(row==arr.length-1 && col==arr[0].length-1){
                System.out.println(p);
                return;
            }else if(row==arr.length-1 && !(col==arr[0].length-1)){
                printPath(p+"R",row, col+1, arr);
                return;
            }else{
                printPath(p+"D",row+1, col, arr);
                return;
            }
        }
        printPath(p+"D",row+1, col, arr);
        printPath(p+"R",row, col+1, arr);
    }
    static ArrayList<String> pathList(String p,int row,int col,int[][] arr){
        if(row == arr.length-1 || col == arr[0].length-1){
            if(row==arr.length-1 && col==arr[0].length-1){
                ArrayList<String> list = new ArrayList<>();
                list.add(p);
                return list;
            }else if(row==arr.length-1 && !(col==arr[0].length-1)){
                return pathList(p+"R",row, col+1, arr);
            }else{
                return pathList(p+"D",row+1, col, arr);
            }
        }
        ArrayList<String> down = pathList(p+"D",row+1, col, arr);
        ArrayList<String> right = pathList(p+"R",row, col+1, arr);
        down.addAll(right);

        return down;
    }
    static int maxFromPath(int sum,int row,int col,int[][] arr){
        if(row == arr.length-1 && col == arr[0].length-1){
            return sum+arr[row][col];
        }
        else if(row == arr.length-1 && !(col == arr[0].length-1)){
            return maxFromPath(sum+arr[row][col],row,col+1,arr);
        }else if(!(row == arr.length-1) && col == arr[0].length-1){
            return maxFromPath(sum+arr[row][col], row+1, col, arr);
        }

        int down = maxFromPath(sum+arr[row][col], row+1, col, arr);
        int right = maxFromPath(sum+arr[row][col], row, col+1, arr);

        return Math.max(down,right);
    }
    // a correct example of backtracking concept
    static void allPathFromUDLR(String p,int row,int col,boolean[][] arr){
        if(row == arr.length-1 && col == arr[0].length-1){
            System.out.println(p);
            return;
        }

        if(!arr[row][col]){
            return;
        }
        // i am considering this block is my path and making the current block as visited
        arr[row][col] = false;
        
        if(row<arr.length-1){
            allPathFromUDLR(p+"D", row+1, col, arr);
        }

        if(col < arr[0].length-1){
            allPathFromUDLR(p+"R", row, col+1, arr);
        }

        if(row>0){
            allPathFromUDLR(p+"U", row-1, col, arr);
        }

        if(col>0){
            allPathFromUDLR(p+"L", row, col-1, arr);
        }

        // while exiting the function we should make the block as not visited for able to use this block in other path traversal
        arr[row][col] = true;
    }
    static void printAllPath(String p,int row,int col,boolean[][] arr,int[][] resultMatrix,int step){
        if(row==arr.length-1 && col==arr[0].length-1){
            resultMatrix[row][col]=step;
            for(int[] r:resultMatrix){
                System.out.println(Arrays.toString(r));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!arr[row][col]){
            return;
        }
        // update the block value as visited in current block to restrict visiting again in the single path
        arr[row][col] = false;
        // update the block value in resultMatrix with current step value
        resultMatrix[row][col]=step;

        if(row < resultMatrix.length-1){
            printAllPath(p+"D", row+1, col, arr, resultMatrix, step+1);
        }

        if(col < resultMatrix[0].length-1){
            printAllPath(p+"R", row, col+1, arr, resultMatrix, step+1);
        }

        if(row > 0){
            printAllPath(p+"U", row-1, col, arr, resultMatrix, step+1);
        }

        if(col > 0){
            printAllPath(p+"L", row, col-1, arr, resultMatrix, step+1);
        }

        // updating the boolean array as not visited before exiting the path which is reqiured to check other possible paths
        arr[row][col] = true;
        // similarly updating the step value in the resultMatrix for other paths
        resultMatrix[row][col] = 0;
    }

    // n queens problem
    static void nQueens(boolean[][] board,int row){
        if(row==board.length){
            displayQueen(board);
            System.out.println();
            return;
        }
        for(int col=0;col<board.length;col++){
            if(isQueenSafe(board,row,col)){
                board[row][col] = true;
                nQueens(board, row+1);
                board[row][col] = false;
            }
        }
    }
    static void displayQueen(boolean[][] board){
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board.length;col++){
                if(board[row][col]==false){
                    System.out.print("x ");
                }else{
                    System.out.print("Q ");
                }
            }
            System.out.println();
        }
    }
    static boolean isQueenSafe(boolean[][] board,int row,int col){
        // check vertical line
        for (int i = 0; i < row; i++) {
            if(board[i][col]){
                return false;
            }
        }
        // check diagonal left
        int r=row,c=col;
        while(c>=0 && r>=0){
            if(board[r][c]){
                return false;
            }
            r--;c--;
        }
        // chech right diagonal
        r=row;c=col;
        while(c<board.length && r>=0){
            if(board[r][c]){
                return false;
            }
            r--;c++;
        }
        return true;
    }
    static void nKnights(boolean[][] board,int row,int col,int target){
        if(target == 0){
            displayQueen(board);
            System.out.println();
            return;
        }
        if(row == board.length-1 && col == board.length){
            return;
        }
        if(col == board.length){
            nKnights(board, row+1, 0, target);
            return;
        }
        if(isKnightSafe(board, row, col)){
            board[row][col] = true;
            nKnights(board, row, col+1, target-1);
            board[row][col] = false;
        }
        nKnights(board, row, col+1, target);
    }
    static boolean isKnightSafe(boolean[][] board,int row,int col){
        // checking upward ossiblity
        if(row >=2){
            if(col>=1){
                if(board[row-2][col-1]){
                    return false;
                }
            }
            if(col < board.length-1){
                if(board[row-2][col+1]){
                    return false;
                }
            }
        }
        // checking downward possiblity
        if(row < board.length-2){
            if(col >=1){
                if(board[row+2][col-1]){
                    return false;
                }
            }
            if(col < board.length-1){
                if(board[row+2][col+1]){
                    return false;
                }
            }
        }
        // checking left side
        if(col>=2){
            if(row>=1){
                if(board[row-1][col-2]){
                    return false;
                }
            }
            if(row < board.length-1){
                if(board[row+1][col-2]){
                    return false;
                }
            }
        }
        // checkinh right side
        if(col < board.length-2){
            if(row >=1){
                if(board[row-1][col+2]){
                    return false;
                }
            }
            if(row < board.length-1){
                if(board[row+1][col+2]){
                    return false;
                }
            }
        }

        return true;
    }

    static boolean sudokuSolver(char[][] board){
        int n = board.length;
        int row = -1,col = -1;
        boolean emptyLeft = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == '.'){
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            if(!emptyLeft){
                break;
            }
        }
        if(emptyLeft){
            return true;
        }

        // backtrack
        for (char i = '1'; i <='9'; i++) {
            if(isValid(board, row, col, i)){
                board[row][col] = i;
                if(sudokuSolver(board)){
                    return true;
                }else{
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }
    static boolean isValid(char[][] board,int row,int col,char c){
        // check current row
        for (int i = 0; i < board.length; i++) {
            if(board[row][i]==c){
                return false;
            }
        }
        
        // chech current column
        for (int i = 0; i < board.length; i++) {
            if(board[i][col]==c){
                return false;
            }
        }
        // check 3x3 sub matrix
        int rStart = row - (row%3), cStart = col - (col%3);
        for (int i = rStart; i < rStart+3; i++) {
            for (int j = cStart; j < cStart+3; j++) {
                if(board[i][j] == c){
                    return false;
                }
            }
        }
        return true;
    }
    static void displaySudoku(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
