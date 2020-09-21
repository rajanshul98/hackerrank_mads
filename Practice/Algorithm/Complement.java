//Question Links :- https://www.hackerearth.com/challenges/college/himw-1/algorithm/ca97b5ecfe584d138dc81afa08841bac/

import java.io.*;
class Complement{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        int q = Integer.parseInt(br.readLine());
        int[] ref = new int[n+1];
        while(q-- > 0){
            s = br.readLine().split(" ");
            int l = Integer.parseInt(s[0]);
            int r = Integer.parseInt(s[1]);
            ref[l-1] = ref[l-1] + 1;
            ref[r] = ref[r] - 1;
        }
        int count = 0;
        for(int i = 0; i <= n; i++){
            if(i > 0)
                ref[i] += ref[i-1];
            if(i < n){
                if(ref[i] % 2 == 1){
                    arr[i] = arr[i] ^ 1;
                }
                if(arr[i] == 1)
                    count++;
            }   
        }
        System.out.println(count);
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++){
            sb.append(arr[i] + " ");
        }
        System.out.print(sb);
    }
}
