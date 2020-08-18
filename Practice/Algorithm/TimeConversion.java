import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static String timeConversion(String s) { 
        String temp = s.substring(0,2);
        int time = 0;
        if(s.substring(8,s.length()).equals("PM")){
            time = 12 + Integer.valueOf(temp) % 12;
        }
        else if(s.substring(8,s.length()).equals("AM")){
            time = Integer.valueOf(temp) % 12;
        }
        if(time < 10)
            temp = s.replace(temp, "0" + String.valueOf(time));
        else
            temp = s.replace(temp, String.valueOf(time));
        return temp.substring(0, temp.length()-2);
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
