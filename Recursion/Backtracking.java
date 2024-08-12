public class Backtracking {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(countPath(0, 0, arr));
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
}
