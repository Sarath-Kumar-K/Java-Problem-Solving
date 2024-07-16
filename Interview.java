import java.util.Arrays;

public class Interview {
    public static void main(String[] args) {
       int[][] matrix1 = {{1,2,3},{4,5,6}};
       int[][] matrix2 = {{10,11},{20,21},{30,31}};
       int[][] result = matrixMultiplication(matrix1, matrix2);
       for (int i = 0; i < result.length; i++) {
        System.out.println(Arrays.toString(result[i]));
       }
    }

    public static boolean isEven(int num) {
        if ((num & 1) == 1) {
            return false;
        }

        return true;
    }

    public static boolean isprime(int num) {
        if (num < 2) {
            return false;
        } else if (num == 2) {
            return true;
        } else {
            int limit = (int) Math.round(Math.sqrt(num));
            for (int i = 2; i <= limit; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int factorial(int num){
        while(num>=1){
            return num * factorial(num-1);
        }

        return 1;
    }
    public static int reverse(int num){
        int sum=0;
        while(num>0){
            sum = sum * 10 + (num % 10);
            num=num/10;
        }
        return sum;
    }
    public static String reverse(String str){
        return (new StringBuilder(str).reverse().toString());
    }
    public static boolean isPlaindrome(int num){
        return num == reverse(num);
    }
    public static boolean isPlaindrome(String str){
        return str.equals(reverse(str));
    }

    public static void printFibonacci(int limit){
        int first = 0;
        int second = 1;
        int temp;
        System.out.print(first +  " "+ second);
        for(int i=3;i<=limit;i++){
            System.out.print(" " + (first + second));
            second = first + second;
            first = second - first; 
        }
    }

    public static boolean isArmstrong(int num){
        int temp = num,sum = 0;
        while(temp>0){
            sum = sum + (int)(Math.pow(temp%10, (num+"").length()));
            temp/=10;
        }

        return num == sum;
    }

    public static int[] bubbleSort(int[] nums){ 
        for (int i = 0; i < nums.length; i++) {
            boolean swapped = false;
            for(int j=1;j<nums.length-i;j++){
                if(nums[j] < nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
        return nums;
    }

    public static int[][] matrixMultiplication(int[][] matrix1, int[][] matrix2){
        int[][] result = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for(int j=0;j<matrix2[0].length;j++){
                for(int k=0;k<matrix2.length;k++){
                    result[i][j] = result[i][j] + ( matrix1[i][k] * matrix2[k][j] );
                }
            }
        }

        return result;
    }
}
