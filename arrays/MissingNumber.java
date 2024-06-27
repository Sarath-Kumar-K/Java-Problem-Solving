package arrays;

/* 
Problem Statement:
Find the missing element from the given array which contains elements in the range [0,n]
cyclic sort example problem which gives the missing number from a given range here we take it as [0,9] range
*/
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        // int ans = findMissing(nums);
        System.out.println(sort(nums));
    }

    static int sort(int[] nums){
        int i=0;
        while(i<nums.length){
            if(nums[i] < nums.length && nums[i] != i){
                swap(nums,i,nums[i]);
            }else i++;
        }
        // iterate in loop to check if all the alments are in correct index if not then the deserved value is the missing number.
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j) return j;
        }
        // return the length if all the elements are in correct position as the length will the remaining in the range 
        return nums.length;
    }

    static void swap(int[] nums,int first,int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
