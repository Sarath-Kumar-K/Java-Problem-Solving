import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        mergeSortInPlace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    static void bubbleSort(int[] arr,int left,int right){
        if(right == 0){
            return;
        }

        if(left == right){
            bubbleSort(arr, 0, right-1);
        }else{
            if(arr[left] > arr[left+1]){
                int temp = arr[left];
                arr[left] = arr[left+1];
                arr[left+1] = temp;
            }
            bubbleSort(arr, left+1, right);
        }
    }
    static void selectionSort(int[] arr,int left,int right,int max){
        if(right == 0){
            return;
        }
        if(left == right+1){
            int temp = arr[right];
            arr[right] = arr[max];
            arr[max] = temp;
            selectionSort(arr, 0, right-1, 0);
        }else{
            selectionSort(arr, left+1, right, (arr[left]>arr[max])? left:max);
        }
    }
    static int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }

        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left,right);
    }
    static int[] merge(int[] left,int[] right){
        int[] mix = new int[left.length + right.length];
        int i=0,j=0,k=0;
        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                mix[k] = left[i];
                i++;
            }else{
                mix[k] = right[j];
                j++;
            }
            k++;
        }
        // treversing through remaining elements in the array
        while(i<left.length){
            mix[k] = left[i];
            i++;
            k++;
        }
        while(j<right.length){
            mix[k] = right[j];
            j++;
            k++;
        }

        return mix;
    }
    // mergesort using in-place method i.e without creating new array just manipulate exsisting array with indexes
    static void mergeSortInPlace(int[] arr,int start,int end){
        if(end - start == 1){
            return ;
        }

        int mid = (start + end) / 2;
        mergeSortInPlace(arr, start, mid);
        mergeSortInPlace(arr, mid, end);

        mergeInPlace(arr,start,mid,end);
    }
    static void mergeInPlace(int[] arr,int start,int mid,int end){
        int[] mix = new int[end-start];
        int i = start, j = mid, k = 0;

        while(i<mid && j<end){
            if(arr[i]<arr[j]){
                mix[k] = arr[i];
                i++;
            }else{
                mix[k] = arr[j];
                j++;
            }
            k++;
        }
        // traverse through remaining elements
        while(i < mid){
            mix[k] = arr[i];
            i++;
            k++;
        }
        while(j < end){
            mix[k] = arr[j];
            j++;
            k++;
        }

        // updating mix with original array
        for (int l = 0; l < mix.length; l++) {
            arr[start + l] = mix[l];
        }
    }
}
