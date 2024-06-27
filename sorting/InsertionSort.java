package sorting;
import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1,5,4,3,2};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void sort(int[] nums){
        for (int i = 0; i <= nums.length-2; i++) {
            for (int j = i+1; j>0; j--) {
                if(nums[j] < nums[j-1]) swap(nums,j,j-1);
                else break;
                
            }
        }
    }

    static void swap(int[] nums,int first,int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
