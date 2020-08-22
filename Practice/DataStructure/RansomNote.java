import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int len = magazine.length;
        for(int i =0; i < len; i++){
            if(map.containsKey(magazine[i]))
                map.put(magazine[i], map.get(magazine[i])+1);
            else
                map.put(magazine[i], 1);
        }
        int len2 = note.length;
        boolean flag = true;
        for(int i =0; i < len2; i++){
            if(!(map.containsKey(note[i]) && map.get(note[i]) >=1)){
                flag = false;
                break;
            }
            map.put(note[i], map.get(note[i])-1);
        }
        
        if(flag)
            System.out.println("Yes");
        else
            System.out.println("No");


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
