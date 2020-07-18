//Question link - https://www.hackerrank.com/challenges/array-left-rotation/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LeftRotation{


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }
        scanner.close();
        Solution.leftShift(a,d);
        for(int i = 0; i < n ; i++){
            System.out.print(a[i] + " ");
        }
    }
    public static int[] leftShift(int[] a, int d){
        int[] temp = new int[d];
        int n = a.length;
        for(int i = 0; i < d; i++){
            temp[i] = a[i]; 
        }
        for(int i = 0; i < n - d; i++){
            a[i] = a[i+d];
        }
        for(int i = n-d, k = 0; i < n; i++,k++){
            a[i] = temp[k];
        }
        return a;
    }
}
