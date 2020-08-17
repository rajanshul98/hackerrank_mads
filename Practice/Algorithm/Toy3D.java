import java.util.Scanner;
import static java.lang.Math.min;
public class Toy3D {
	public static int calculateArea(int[][] stack, int row, int col) {
		int[][] area = new int[row][col];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				area[i][j] = (2 * 1) + (stack[i][j] * 4);
			}
		}
		int l = 0, r = 0, u =0, d = 0, sum = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(j > 0)
					l = min(stack[i][j], stack[i][j-1]);
				if(j < col - 1)
					r = min(stack[i][j], stack[i][j+1]);
				if(i > 0)
					u = min(stack[i][j], stack[i-1][j]);
				if(i < row - 1)
					d = min(stack[i][j], stack[i+1][j]);
				area[i][j] = area[i][j] - (l + r + u + d);
				sum += area[i][j];
				l = 0; r = 0; u = 0; d = 0;
			}
		}
		return sum;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int row = 0, col = 0;
		row = sc.nextInt();
		col = sc.nextInt();
		int[][] stack = new int[row][col];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				stack[i][j] =  sc.nextInt();
			}
		}
		int area = calculateArea(stack, row, col);
		System.out.println(area);
	}
}
