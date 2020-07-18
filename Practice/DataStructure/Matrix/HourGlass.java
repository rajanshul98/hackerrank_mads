//Question Link - https://www.hackerrank.com/challenges/2d-array/problemimport java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HourGlass{

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] matrix) {
        int maxsum = Integer.MIN_VALUE;
        int sum = 0, jj = 0;
        for(int i = 0;i < 4;i++) {
            sum = 0;
            for(int j = jj;j < jj+3;j++) {
                sum += matrix[i][j];
                if(j==jj) sum += matrix[i+1][jj+1];
                sum += matrix[i+2][j];
            }
            jj = (jj < 3) ? jj+1 : 0;
            if(sum > maxsum) maxsum = sum;
            if(jj != 0) 
                i--;
        }
        return maxsum;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
