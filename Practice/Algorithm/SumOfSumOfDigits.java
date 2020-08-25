
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


class SumOfSumOfDigits {
    public static long getDigitValue(long num){
        long sum = 0;
        while(num > 0){
            sum = sum + num%10;
            num = num/10;
        }
        if(sum >= 10)
            return getDigitValue(sum);

        return sum;
    }
    public static void preCalculate(long[] num, int n){
        for(int i = 0; i < n; i++){
            long digit_val = getDigitValue(num[i]);
            num[i] = digit_val;
        }
      
    }
    public static void advancePreCalculateSum(long[] num, int n){
        for(int i = 1; i < n; i++){
            num[i] = num[i] + num[i-1];
        }
      
    }

    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int q = Integer.parseInt(s[1]);
        long[] num = new long[n];
        s = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            num[i] = Long.parseLong(s[i]);
            
        }
        preCalculate(num, n);
        Arrays.sort(num);
        advancePreCalculateSum(num, n);
        int type, size;
        long res;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++){
            s = br.readLine().split(" ");
            type = Integer.parseInt(s[0]);
            size = Integer.parseInt(s[1]);
            if(type == 1){
                if(size == n)
                    res = num[n-1];
                else
                    res = num[n-1] - num[n-size-1];
            }
            else{
                res = num[size-1];
            }
        
            sb.append(String.valueOf(res) + "\n");
        }
        System.out.print(sb.toString());
    }
}
