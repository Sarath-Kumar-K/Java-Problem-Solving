package arrays;
/*
 * Problem staement:
 * Find the Peak or Greatest from an Bitonic or Mountain array
 * Note : A bitonic or mountain array is an array where it keeps incresing at some point 
 * and then decreses to the last.
 */

public class FindPeakInBitonicArray {

    public static void main(String[] args) {
       int[] arr = {1,2,3,4,5,6,7,8,9,90,9,8,7,6,5,4,3,2,1};
       System.out.println(binarySearch(arr)); 
    }

    static int binarySearch(int[] arr){
        int start=0, end=arr.length-1; 
        while(start<end){
            int mid = start + (end - start) / 2;
            if(arr[mid] > arr[mid+1]) end = mid;
            else if(arr[mid] < arr[mid+1]) start = mid +1;
        }
        return (arr[start] > arr[end])? arr[start]:arr[end];
    }

}
