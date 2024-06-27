package arrays;
/*
 * Problem Staement:
 * find the target character from the given character array 
 * which is sorted in alphbetic order 
 * if not found return or print the first character in the array
 */

public class SearchInSortedCharArray {
    public static void main(String[] args) {
        char[] arr = {'a','a','c','e','g','g','h','z'};
        char target='e';
        System.out.println(searchbykunal(arr,target)); 
       
    }

    static char searchbykunal(char[] letters, char target){
        int start=0, end = letters.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            System.out.println("start = "+start+" end = "+end+ " mid = "+mid);
            if(letters[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        System.out.println(start+ " % "+letters.length+" = "+start % letters.length);

        return letters[start % letters.length];
    }

    static char search(char[] letters, char target){
        int start=0, end = letters.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(letters[mid]==target){
                if(mid==letters.length-1 ) return letters[0];
                else if(letters[mid+1]==target) start=mid+1;
                else return letters[mid+1];
            }else if(start == end){
                if(letters[mid]<target && mid!=letters.length-1) return letters[mid+1];
                else if(letters[mid] > target) return letters[mid];
                else return letters[0];
            }else if(letters[mid] > target) end = mid -1;
            else start = mid +1;
        }
        
        return letters[0];
    }
    static int search(int[] arr,int target){
        int start =0, end = arr.length-1;
        while(start<=end){
            int mid=start + (end-start)/2;
            System.out.println("start = "+start+" end = "+end+" mid = "+mid);
            if(arr[mid]==target) return target;
            else if(start==end){
                if( arr[mid]>target && mid!=0 ) return arr[mid-1];
                else if( arr[mid]<target ) return arr[mid];
                else return -1;
            }
            else if(arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    
}
