import java.util.*;

public class Test {
    public static void main(String[] args) {
        int[] nums = {1,2,2,4,1,3,6,3,4};
        unique(nums);
    }

    public static void OddOrEven(int num){
        if((num & 1) == 1){
            System.out.println("Odd");
        }else{
            System.out.println("Even");
        }
    }

    public static void unique(int[] nums) {
        int sum = 0;
        for(int i:nums){
            sum^=i;
        }
        System.out.println(sum);
    }

}
