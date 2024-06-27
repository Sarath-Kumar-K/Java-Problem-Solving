package sorting;
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {2,1,-43,0};
        selectionsort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void selectionsort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
           findmaxandswap(nums,0,nums.length-1-i);
        }
    }

    static void findmaxandswap(int[] nums,int start,int end){
        int max = nums[start], maxpos = start;
        for (int i = start+1; i <= end; i++) {
            if(nums[i] > max){
                max = nums[i];
                maxpos = i;
            }
        }
        int temp = nums[end];
        nums[end] = max;
        nums[maxpos] = temp; 
        
    }
}
