import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] b = new int[2][n+1];
        for(int j = 0; j < m; j++){
            s = br.readLine().split(" ");
            String temp = s[0];
            int set1 = Integer.parseInt(s[1]);
            int set2 = Integer.parseInt(s[2]);
            switch (temp){
                case "AND":
                    for(int i = 0; i <= n; i++){
                        b[set1-1][i] &= b[set2-1][i];
                    }
                    break;
                case "OR":
                    for(int i = 0; i <= n; i++){
                        b[set1-1][i] |= b[set2-1][i];
                    }
                    break;
                case "XOR":
                    for(int i = 0; i <= n; i++){
                        b[set1-1][i] ^= b[set2-1][i];
                    }
                    break;
                case "FLIP":
                    b[set1-1][set2] ^= 1;
                    break;
                case "SET":
                    b[set1-1][set2] = 1;
                    break;
                default:
                    break;
            }
            int cnt1 = 0, cnt2 = 0;
            for(int i = 0; i <= n; i++){
                if(b[0][i] == 1)
                    cnt1++;
                if(b[1][i] == 1)
                    cnt2++;
            }
            System.out.println(cnt1 + " " + cnt2);
        }
    }
}
