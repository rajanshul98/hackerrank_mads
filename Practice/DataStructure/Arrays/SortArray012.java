// { Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;

class SortArray012{

public static void sort012(int arr[], int n){
    
    int nz = 0, no = 0;
    for(int i = 0; i < n; i++){
        if(arr[i] == 0){ 
            nz++;
            arr[nz-1] = 0;
        }
        else if(arr[i] == 1)
            no++;
    }
    int totalz1 = nz + no;
    //System.out.println(nz + "\t" + no + "\t" + totalz1);
    for(int i = nz; i < totalz1; i++)
        arr[i] = 1;
        
    for(int i = totalz1; i < n; i++)
        arr[i] = 2;
}

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}
