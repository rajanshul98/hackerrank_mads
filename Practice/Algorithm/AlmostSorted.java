import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the almostSorted function below.
    public static boolean checkSorted(int[] arr, int n){
        for(int i = 0; i < n-1; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }
    public static void swap(int[] arr, int li, int ri){
        int temp = arr[li];
        arr[li] = arr[ri];
        arr[ri] = temp;
    }

    public static void reverse(int[] arr, int low, int high){
        while(low < high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    static void almostSorted(int[] arr) {
        int n = arr.length;
        if(checkSorted(arr, n)){
            System.out.println("yes");
            return;
        }
        else{
            int i = 0, j = n-1;
            for(; i < n-1 && arr[i] < arr[i+1]; ++i);
            for(; j > 0 && arr[j] > arr[j-1]; --j);
            swap(arr, i, j);
            if(checkSorted(arr, n)){
                System.out.println("yes\nswap " + (i+1) + " " + (j+1));
                return;
            }
            reverse(arr, i+1, j-1); // if array is still not sorted then reverse the segement of array
            if(checkSorted(arr, n)){
                System.out.println("yes\nreverse " + (i + 1) + " " + (j+1));
                return;
            }          
            System.out.println("no");  
        }
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        almostSorted(arr);

        scanner.close();
    }
}
