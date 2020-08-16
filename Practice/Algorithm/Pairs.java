import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the pairs function below.
    static int pairs2(int k, int[] arr){
        Arrays.sort(arr);
        int i = 0, j = 1, count = 0, n = arr.length;
        int diff = 0;
        while(j < n){
            diff = arr[j] - arr[i];
            if(diff == k){
                count++;
                j++;
            }
            else if(diff < k)
                j++;
            else
                i++;
        }
        return count;
    }
    
    static int pairs(int k, int[] arr) {
        Arrays.sort(arr);
        int count = 0, n = arr.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(Math.abs(arr[i] - arr[j]) > k)
                    break;
                if(Math.abs(arr[i] - arr[j]) == k)
                    count++;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
