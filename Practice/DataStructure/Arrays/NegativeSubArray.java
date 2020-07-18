question link - https://www.hackerrank.com/challenges/java-negative-subarray/problem

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class NegativeSubArray{

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr=new int[n];
        int negative_sub_count=0;
        for (int i=0; i<n; i++){
            arr[i]=sc.nextInt(); 
            int s=arr[i];
            if (s<0) negative_sub_count++;
            for (int j=i-1; j>=0; j--){
                s+=arr[j];
                if (s<0) negative_sub_count++;
            }
        }
        System.out.println(negative_sub_count);
    }
}
