import java.io.*;
import static java.lang.Math.min;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int row, int col, int[][] obs) {
        int l = col - 1, r = n - col, u = n - row, d = row - 1;
        int lu = min(l, u), ld = min(l,d), ru = min(r, u), rd = min(r, d);
        for(int i = 0; i < k; i++){
            if(obs[i][0] == row){
                if(obs[i][1] < col)
                    l = min(l, col - obs[i][1] - 1);
                else
                    r = min(r, obs[i][1] - col - 1);
            }
            else if(obs[i][1] == col){
                if(obs[i][0] > row)
                    u = min(u, obs[i][0] - row - 1);
                else
                    d = min(d, row - obs[i][0] - 1);
            }
            else if(Math.abs(row - obs[i][0]) == Math.abs(col - obs[i][1])){
                if(obs[i][0] > row){
                    if(obs[i][1] < col)
                        lu = min(lu, col - obs[i][1] - 1);
                    else
                        ru = min(ru, obs[i][1] - col - 1);
                }
                else{
                    if(obs[i][1] < col)
                        ld = min(ld, col - obs[i][1] - 1);
                    else
                        rd = min(rd, obs[i][1] - col - 1);
                }
            }
        }
        int result = l + r + u + d + lu + ld + ru + rd;
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
