// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

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
		    
		    Trap obj = new Trap();
		    
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}

// } Driver Code Ends


class Trap{
    
    // function to find the trapped water in between buildings
    // arr: input array
    // n: size of array
    static int trappingWater(int arr[], int n) { 
        int[] lmax = new int[n];
        int[] rmax = new int[n];
    //int max = Integer.MIN_VALUE;
        lmax[0] = arr[0];
        for(int i = 1; i < n; i++){
            if(lmax[i-1] > arr[i])
                lmax[i] = lmax[i-1];
            else
                lmax[i] = arr[i];
        }
        //lmax[n-1] = arr[n-1];
        rmax[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; i--){
            if(rmax[i+1] > arr[i])
                rmax[i] = rmax[i+1];
            else
                rmax[i] = arr[i];
        }
        //rmax[0] = arr[0];
        int unit = 0;
        for(int i = 0; i < n; i++){
            int minm = Math.min(lmax[i], rmax[i]);
            unit += (minm - arr[i]);
        }
        return unit;
    }
}

