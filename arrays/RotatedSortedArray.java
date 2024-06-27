/*
 * Problem Statement:
 * Find the target elemnt form the given rotated Sorted array
 * Note : A rotated sorted array is an array when you push the 
 * last elements to the front of the array one by one
 * i.e 0,1,2,4,5,6,7 becomes 4,5,6,7,0,1,2 after 4 rotations
 */

package arrays;

public class RotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int peakIndex = findPeakIndex(nums);
        int firstHalf = binarySearch(nums,target,peakIndex,true);
        if(firstHalf == -1) System.out.println(binarySearch(nums,target,peakIndex,false));
        else System.out.println(firstHalf);
    }
    
    static int findPeakIndex(int[] nums){
        int start=0, end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[end]){
                start = mid;
            }else end = mid+1;
        }
        return start;
    }
    
    static int binarySearch(int[] nums, int target,int peakindex,boolean firstHalf){
        int start,end;
        if(firstHalf){
            start = 0;
            end = peakindex;
        }else{
            start = peakindex + 1;
            end = nums.length -1;
        }
        
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid] > target) end = mid -1;
            else start = mid + 1;
        }
        return -1;
    
    }
}
