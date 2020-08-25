//Question link - https://practice.geeksforgeeks.org/problems/validate-an-ip-address-1587115621/1
import java.io.*;
public class IPValidation {
	public static boolean validate2(String S) {
        int len = S.length(), dots = 0;
        for(int i = 0; i < len; i++) {
        	if(S.charAt(i) == '.')
        		dots++;
        }
		if(dots != 3) {
			System.out.println("There should be only 4 octet");
			return false;
		}
		else{
			String[] ip = S.split("\\.");
			len = ip.length;
			if(len < 4){
				System.out.println("There should be only 4 octet");
				return false;
			}
				
			int[] oct = new int[4];
			for(int i = 0; i < len; i++) {
			    int j = 0; 
                while (j < ip[i].length() && ip[i].charAt(j) == '0') 
                    j++; 
                if(j > 1)
                    return false;
                else{
                    try{
				        oct[i] = Integer.parseInt(ip[i]);
				        if(j == 1 && oct[i] != 0)
				            return false;
				        if(oct[i] < 0 || oct[i] > 255) {
					    System.out.println("Value of each octet should be in range 0-255");
					        return false;
				        }
                    }
				    catch(Exception e){
				    		System.out.println("Each octet should contains value in range 0-255");
				            return false;
				    }
			    }
            }
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ip = br.readLine();
		boolean val = validate2(ip);
		if(val) 
			System.out.println("IP is valid");
		else
			System.out.println("IP is not valid");
	}
}
