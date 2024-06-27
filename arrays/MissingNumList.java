package arrays;
/*
 * Problem Statement:
 * find the missing numbers from an array given the elements of the array lies in the range [0,n]
 * for the below example the range is [1,8]
 * Edge Case: Repetition also allowed in the array
 */


import java.util.Arrays;


public class MissingNumList {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        cyclicsort(nums);
        System.out.println(Arrays.toString(nums));

    }

    static void cyclicsort(int[] nums){
        int i=0;
        while(i<nums.length){
            if(nums[i] <= nums.length && nums[i] != i+1 && nums[nums[i]-1] != nums[i]){
                swap(nums,i,nums[i]-1);
            }else i++;
        }
    }

    static void swap(int[] nums,int first,int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    
}
