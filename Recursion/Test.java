import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{5,6,7,8,9,1,2,3,4};
        System.out.println(roratedBinarySearch(arr, 2, 0,arr.length-1));
    }
    static int roratedBinarySearch(int[] arr,int target,int start,int end){
        if(start > end){
            return -1;
        }
        int mid = start + (end - start)/2;
        if(arr[mid] == target){
            return mid;
        }

        if(arr[mid] >= arr[start]){
            if(target >= arr[start] && target <= arr[mid]){
                return roratedBinarySearch(arr, target, start, mid-1);
            }else{
                return roratedBinarySearch(arr, target, mid+1, end);
            }
        }

        if(target >= arr[start] && target >= arr[mid]){
            return roratedBinarySearch(arr, target, start, mid-1);
        }
        
        return roratedBinarySearch(arr, target, mid+1, end); 
        
        
    }
    static void printNumInRev(int n){
        if(n == 1){
            System.out.println(n);
            return;
        }
        printNumInRev(n-1);
        System.out.println(n);
    }
    static void printNumRevBoth(int n){
        if(n == 0){
            return;
        }
        System.out.print(n +  " ");
        printNumRevBoth(n-1);
        System.out.print(n + " ");
    }
    static int factorial(int n){
        if(n == 1){
            return 1;
        }

        return n * factorial(n-1);
    }
    static int sumOfDigits(int n){
        return n<1 ? 0:(n%10)+sumOfDigits(n/10);
    }
    static int sum = 0;
    // getting reverse of a number using a static variable outside the function to store values
    static void reverseNum1(int n){
        if(n < 1){
            return;
        }
        sum = sum * 10 + n%10;
        reverseNum1(n/10);
    }
    // using two paramters one is n and another is sum = 0 as a initial paramter
    static int reverseNum2(int n,int sum){
        return n==0? sum: reverseNum2( n/10, (sum*10) + (n%10) );
    }
    // using helper function reversing a number
    static int reverseNum3(int n){
        int digits = (int)(Math.log10(n)) + 1;
        return helper(n,digits);
    }
    static int helper(int n,int digits){
        return (n%10 == n)? n : n%10 * (int) Math.pow(10,digits-1) + helper(n/10, digits-1);
    }
    static int countZeros(int n,int sum){
        if(n%10 == n){
            if(n==0){
                return 1;
            }else{
                return sum;
            }
        }
        return countZeros(n/10, sum + ((n%10==0)?1:0));
    }
    static boolean isSorted(int[] arr,int index){
        if(index == arr.length-1){
            return true;
        }
        return arr[index] <= arr[index+1] && isSorted(arr, index+1);
    }
    static int findTargetIndex(int[] arr,int target,int index){
        if(index == arr.length){
            return -1;
        }
        if(arr[index] == target){
            return index;
        }
        return findTargetIndex(arr, target, ++index);
    }
    // arraylist as a parameter
    static ArrayList<Integer> getIndexListOfTarget(int[] arr,int target,int index,ArrayList<Integer> list){
        if(index == arr.length){
            return list;
        }
        if(arr[index] == target){
            list.add(index);
        }

        return getIndexListOfTarget(arr, target, ++index, list);
    }
    //without arraylist parameter
    static ArrayList<Integer> getIndexListOfTarget(int[] arr,int target,int index){
        ArrayList<Integer> list = new ArrayList<>();
        if(index == arr.length){
            return list;
        }
        if(arr[index] == target){
            list.add(index);
        }
        ArrayList<Integer> listReturned = getIndexListOfTarget(arr, target, ++index);
        list.addAll(listReturned);
        return list;
    }
}