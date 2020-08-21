import java.io.*;

class CircularSubArraySum{
    
	public static void main (String[] args) throws IOException {
		   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    int n = Integer.parseInt(br.readLine());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    System.out.println(maxCircularSubarraySum(arr, n));
	}


    public static int maxCircularSubarraySum(int arr[], int n){
    	//kadane Algorithm starts
    	int max_ending = arr[0];
        int max_sum = arr[0];

        for(int i = 1; i < n; i++){
            max_ending = Math.max(max_ending + arr[i], arr[i]);
            max_sum = Math.max(max_sum, max_ending);
        }
        // kadane Algorithm ends
        if(max_sum < 0)
        	return max_sum;
        int min_ending = arr[0], min_sum = arr[0], total_sum = arr[0];
        for(int i = 1; i < n; i++) {
        	min_ending = Math.min(min_ending + arr[i], arr[i]);
        	min_sum = Math.min(min_ending, min_sum);
        	total_sum += arr[i];
        }
        System.out.println(total_sum + "\n" + min_sum);
        int max_circular_sum = (total_sum - min_sum);
        return Math.max(max_sum, max_circular_sum);
    } 
}

