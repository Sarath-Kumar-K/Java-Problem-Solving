
// leetcode 202
 
public class Happynumber {
    static int digitSum(int n){
            int sum = 0;
            while(n>0){
                sum += (int)Math.pow(n%10,2);
                n/=10;
            }
            return sum;
    }
    static boolean isHappy(int n) {
//         normal set approach
        // Set<Integer> set = new HashSet<>();
        // while(n!=1){
        //     if(set.contains(n)){
        //         return false;
        //     }else{
        //         set.add(n);
        //         n = digitSum(n);
        //     }
        // }
        // return true; time taken for this is 2ms & 40.8mb
        
//         linkedlist approch of slow and fast pointer to find loop
        int slow=n,fast=n;
        do{
            slow = digitSum(slow);
            fast = digitSum(digitSum(fast));
        }while(slow!=fast);
        if(slow==1){
            return true;
        }
        return false;
//         runtime for LL approch is 0ms & 40mb;
    }
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
