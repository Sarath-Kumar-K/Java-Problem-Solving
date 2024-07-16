import java.util.Arrays;

public class Patterns {
    public static void main(String[] args) {
        int[] arr = new int[]{9,8,7,6,5};
        bubbleSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void desc(int rows){
        if(rows==0){
            return;
        }
        for (int i = 0; i < rows; i++) {
            System.out.print("* ");
        }
        System.out.println();
        desc(rows-1);
    }
    // as there are two loops need to solve this problem using loops then we need two variables to solve using recursion
    static void desc(int row,int col){
        if(row == 0){
            return;
        }
        if(row >= col){
            desc(row,col+1);
            System.out.print("* ");
            
        }else{
            desc(row-1,1);
            System.out.println();
            
        }
    }
}
