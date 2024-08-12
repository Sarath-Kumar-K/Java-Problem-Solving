import java.util.*;

public class Test {
    public static void main(String[] args) {
       
    
    }

    public static void test(){
        int[] numbers = {1,2,0};
        int res = Integer.parseInt(Arrays.stream(numbers)
        .mapToObj(String::valueOf)
        .reduce("", String::concat)) + 2;
        System.out.println(res);
    }
    public static void OddOrEven(int num){
        if((num & 1) == 1){
            System.out.println("Odd");
        }else{
            System.out.println("Even");
        }
    }

    public static void unique(int[] nums) {
        // for array like {1,1,2,2,3,4,4} it returns 3 
        // Logic : for any integre i the value of i xor i is always 0 and xor opeartions satisfies assosiative property
        int sum = 0;
        for(int i:nums){
            sum^=i;
        }
        System.out.println(sum);
    }
    public static void checkAnagram(String str1, String str2){
        if(str1.length() != str2.length()){
            System.out.println("False");
        }
        else{
            int count1=0;
            int count2 = 0;
            for(int i=0;i<str1.length();i++){
                count1 = count1 +  str1.charAt(i) - 97;
                count2 = count2 +  str2.charAt(i) - 97;
            }

            if(count1 == count2){
                System.out.println("True");
            }else{
                System.out.println("False");
            }
        }
    }

    public static int maxRepeating(String sequence, String word) {
        if(word.length() > sequence.length() || !sequence.contains(word)){
            return 0;
        }
        
        int count=0;
        while(word.length()<=sequence.length()){
            if(sequence.contains(word)){
                count++;
                word+=word;
                System.out.println("count = "+count);
                System.out.println("word = "+word);
            }else{
                return count;
            }
        }
        
        return count;
        
    }

    public static void palindromes(String str){
        for(int i=0;i<str.length()-2;i++){
            for(int j=i+2;j<=str.length();j++){
                if(isPalindrome(str.substring(i, j))){
                    System.out.println(str.substring(i, j));
                }
            }
        }
    }
    static boolean isPalindrome(String str){
        int left = 0,right = str.length()-1;
        while(left < right){
            if(str.charAt(left) != (str.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
