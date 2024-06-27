package arrays;
/*
Problem Statement:
Find the target element from the given fully sorted 2D matrix
Note: Fully sorted means it is sorted from the element matrix[0][0] to matrix[size-1][size-1];
*/

import java.util.Arrays;

public class FullySortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
        };
        int target = 11;
        System.out.println(Arrays.toString(Search(arr,target)));
    }

    
    static int[] Search(int[][] matrix , int target){
        int rows = matrix.length;
        int cols = matrix[0].length;

        if(rows==1){
            return BinarySearch(matrix,0,0,cols-1,target);
        }

        int rStart = 0;
        int rEnd = rows-1;
        int cMid = cols/2;

        // run the loop until there will be only two rows remaining to search
        while(rStart < (rEnd-1)){
            int mid = rStart + (rEnd-rStart)/2;
            if(matrix[mid][cMid] == target) return new int[] {mid,cMid};
            else if(matrix[mid][cMid] > target) rEnd = mid - 1;
            else rStart = mid + 1;
        }

        // checking the two remaining elements in cmid
        if(matrix[rStart][cMid] == target) return new int[] {rStart,cMid};
        if(matrix[rStart+1][cMid] == target) return new int[] {rStart+1,cMid};

        // still not found then check in remaining four parts of the matrix

        // first part from row 0 and col 0 to colmid-1
        if(target <= matrix[rStart][cMid-1]) return BinarySearch(matrix, rStart,0,cMid-1,target);
        // if not in first part check second part which row =0 and col = cmid + 1 to col end
        if(target <= matrix[rStart][cols-1]) return BinarySearch(matrix, rStart, cMid+1, cols-1, target);
        // if target not lies in second part check third part that is row = rStart+1 and col 0 to col cMid -1
        if(target <= matrix[rStart+1][cMid-1]) return BinarySearch(matrix, rStart+1, 0, cMid-1, target);
        else return BinarySearch(matrix, rStart+1, cMid+1, cols-1, target); // the final part check
        
    }

    // search in the row provided betweeen the col satrt and col end
    static int[] BinarySearch(int[][] matrix,int row,int cStart,int cEnd,int target){
        int start = cStart, end = cEnd;
        while(start < end){
            int mid = start + (end - start)/2;
            if(matrix[row][mid] == target){
                return new int[] {row,mid};
            }else if(matrix[row][mid] > target) end = mid - 1;
            else start = mid +1;
        }

        return new int[] {-1,-1};
    }
}
