/*
 * Problem Statement:
 * Find the target element from an given 2D Array
 * Note: The array is sorted in way that that every row wise it is sorted and every column wise it  is sorted
 */

package arrays;
import java.util.Arrays;


public class Twowaysortedmatrix {
    public static void main(String[] args) {
        int[][] matrix = {{10,20,30,40},{15,25,35,45},{28,29,37,49},{33,34,38,50}};
        int target = 40;
        System.out.println(Arrays.toString(search(matrix, target)));
        
    }
    static int[] search(int[][] matrix,int target){
        int r = 0;
        int c = matrix.length -1;

        while( r < matrix.length && c >= 0 ){
            if(matrix[r][c] == target){
                return new int[] {r,c}; 
            }else if(matrix[r][c] > target) c--;
            else r++;
        }

        return new int[] {-1,-1};

    }
}
