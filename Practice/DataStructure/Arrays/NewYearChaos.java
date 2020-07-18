//https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NewYearChaos{

    // Complete the minimumBribes function below.
    public static void swap(int[] q,int i1, int i2){
        int temp = q[i1];
        q[i1] = q[i2];
        q[i2] = temp;
    }

    static void minimumBribes(int[] q) {
        int bribes = 0;
        int totalbribes = 0;
        int ql = q.length;
        boolean flag = true;
        for(int i = ql-1; i >= 0; i--){

            if(q[i] != i+1){
                if((i-1 >= 0) && q[i- 1] == i+1){
                    totalbribes += 1;
                    swap(q,i,i-1);
                }
                else if(((i-1 >= 0) && (i-2 >= 0)) && q[i-2] == i+1){
                    totalbribes += 2;
                    swap(q,i-1,i-2);
                    swap(q,i,i-1);
                }
                else{
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(totalbribes);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}