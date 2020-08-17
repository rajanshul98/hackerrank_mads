import java.io.*;
public class NextBigger {
	public static void swap(char[] ch, int l, int r) {
		char temp = ch[l];
		ch[l] = ch[r];
		ch[r] = temp;
	}
	
	public static void reverse(char[] ch, int l, int r){
		char temp;
		while(l < r) {
			temp = ch[l];
			ch[l] = ch[r];
			ch[r] = temp;
			l++; r--;
		}
	}
	public static String getBigger(String s) {
		int len = s.length();
		char[] ch = s.toCharArray();
		int l = len - 1, r = len - 1;
		while(l > 0 && ch[l-1] >= ch[l])
			l--;
		if(l <= 0) 
			return "no answer";
		while(ch[r] <= ch[l-1]) {
			r -= 1;
		}
		swap(ch, l-1, r); //swap the value from non-permute part
		reverse(ch, l, len-1); // reverse the non-permute part
		return String.valueOf(ch);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		String s, res;
		while(t-- > 0) {
			s = br.readLine();
			res = getBigger(s);
			System.out.println(res);
		}
	}
}
