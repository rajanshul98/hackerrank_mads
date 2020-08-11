import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int cntvalley = 0, i = 0, l = s.length();
        int sealevel = 0, previous_sealevel = 0;
        while(i < l){
            if(s.charAt(i) == 'U'){
                sealevel += 1;
            }
            else{
                sealevel -= 1;
            }
            if(sealevel == 0)
                previous_sealevel = 0;
            if(sealevel < 0 && previous_sealevel >= 0){
                cntvalley++;
                previous_sealevel = sealevel;
            }
            i++;
        }
        return cntvalley;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
