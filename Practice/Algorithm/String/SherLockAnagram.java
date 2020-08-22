import java.io.*;
import java.util.*;
;

public class SherLockAnagram {

    // Complete the anagram function below.
    public static int anagram(String s) {
    	int total_anagram = 0;
    	int len = s.length();
    	HashMap<String, Integer> k = new HashMap<String, Integer>();
    	for(int i = 1; i < len; i++) {
    		char[] ch = s.substring(0,i).toCharArray();
    		Arrays.sort(ch);
    		String ks = new String(ch);
    		k.put(ks, 1);
    		int l = ks.length();
			for(int j = 1; j <= len; j++) {
    			if(j + l <= len) {
    				ch = s.substring(j, j+l).toCharArray();
    				Arrays.sort(ch);
    				ks = new String(ch);
    				if(k.containsKey(ks))
    					k.put(ks, k.get(ks)+1);
    				else
    					k.put(ks, 1);
    			}
    		}
    	}
    	System.out.println(k);
    	for(String str : k.keySet()) {
    		int num = k.get(str);
    		total_anagram += (num * (num - 1))/2;
    	}
    	return total_anagram;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();
            int result = anagram(s);
            System.out.println(result);
        }

        scanner.close();
    }
}
