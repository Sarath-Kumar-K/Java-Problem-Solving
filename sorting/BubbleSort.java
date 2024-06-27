package sorting;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {3,1,5,4,3,1,5,4};
        bubblesort(nums);
        System.out.println(Arrays.toString(nums));
    }
    
    static void bubblesort(int[] nums){
        for(int i=0;i < nums.length;i++){
            boolean swapped = false;
            for (int j = 1; j < nums.length - i; j++) {
                if(nums[j] < nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                    swapped = true;
                }                
            }
            if(!swapped) break; // breaking the outer loop when there is no swap in ineer loop  i.e already sorted
        }
    }
}
