package sorting;
import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int start = 4;
        int[] nums = {9,8,6,5,4,7};
        sort(nums,start);
        System.out.println(Arrays.toString(nums));
    }

    static void sort(int[] nums,int start){
        int i=0;
        while(i<nums.length){
            int correct = i+start;
            if(nums[i] != correct){
                swap(nums,i,nums[i]-start);
            }else i++;
        }
    }

    static void swap(int[] nums,int first,int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
