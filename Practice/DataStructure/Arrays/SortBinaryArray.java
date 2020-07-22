// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class SortBinaryArray{
    static int[] SortBinaryArray(int arr[], int n) 
    { 
        int nz = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == 0){ 
                nz++;
                arr[nz-1] = 0;
            }
        }
        
        for(int i = nz; i < n; i++)
            arr[i] = 1;
            
        return arr;
    }  
	
    static int[] SortBinaryArray2(int arr[], int n) 
    { 
        //this function uses two pointer concept
        int i = 0, j = n-1;
        while(i <= j){
            if(arr[i] == 1 && arr[j] == 1){
                j--;
            }
            else if(arr[i] == 0 && arr[j] == 0){
                i++;
            }
            else if(arr[i] == 0 && arr[j] == 1){
                i++;
                j--;
            }
            else if(arr[i] == 1 && arr[j] == 0){
                arr[i] = 0;
                arr[j] = 1;
                i++;
                j--;
            }
        }
        return arr;
    }

    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
        	int n = sc.nextInt();
        	int array[] = new int [n];
        	for(int i=0; i<n; i++)
        		array[i] = sc.nextInt();
            int result[] = new int[n];
            result = SortBinaryArray(array,n);
            for(int i=0; i<n; i++)
            	System.out.print(result[i]+" "); 
            System.out.println();
            t--;
        }
    }
}


	

