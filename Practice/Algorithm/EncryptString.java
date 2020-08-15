import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the encryption function below.
    static String encryption(String s) {
        s = s.replaceAll("\\s", "");
        int len = s.length();
        int word = (int)Math.floor(Math.sqrt(len));
        int enc_len = (int)Math.ceil(Math.sqrt(len));
        int i = 0;
        StringBuilder res = new StringBuilder();
        while(i < enc_len){
            StringBuilder temp = new StringBuilder();
            for(int j = i; j < len; j += enc_len){    
                temp.append(s.charAt(j));
            }
            i++;
            res.append(temp + " ");
        }
        return res.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
