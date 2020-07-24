import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PowerSum{
    static int count = 0, powersum = 0;
    private static final Scanner scanner = new Scanner(System.in);
    // Complete the powerSum function below.
    public static void calculatePowerSum(int X, int N, int i){
        powersum += (int)Math.pow(i,N);
        if(powersum == X)
            count++;
        if((int)Math.pow(i,N) == X)
            return;
        for(int j=i+1;(int)Math.pow(j,N) <= X; j++){
            calculatePowerSum(X, N, j);
            powersum -= (int)Math.pow(j,N);
        }
        
    }


    static int powerSum(int X, int N){
        int i = 1;
        for(;(int)Math.pow(i,N) < X; i++){
            powersum = 0;
            calculatePowerSum(X, N, i);
        }
        if((int)Math.pow(i,N) == X)
            count++;
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int X = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = powerSum(X, N);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
