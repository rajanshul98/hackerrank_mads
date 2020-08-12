
import java.util.Scanner;
public class MagicSquare {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[] s) {
    	
        int[][] magic = {{8,3,4,1,5,9,6,7,2},
                        {4,3,8,9,5,1,2,7,6},
                        {8,1,6,3,5,7,4,9,2},
                        {6,1,8,7,5,3,2,9,4},
                        {2,9,4,7,5,3,6,1,8},
                        {6,7,2,1,5,9,8,3,4},
                        {2,7,6,9,5,1,4,3,8},
                        {4,9,2,3,5,7,8,1,6}};
        
        int mincost = Integer.MAX_VALUE;
        for(int i = 0; i < 8; i++){
            int tempcost = 0;
            for(int j = 0; j < 9; j++){
                tempcost = tempcost + Math.abs(s[j] - magic[i][j]);
            }
            //System.out.print(tempcost + " ");
            if(mincost > tempcost)
                mincost = tempcost;
        }
        return mincost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }
        int[] matrix = new int[9];
        int k = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                matrix[k++] = s[i][j];
            }
        }
        
        int result = formingMagicSquare(matrix);
        System.out.println(result);
        scanner.close();
    }
}
