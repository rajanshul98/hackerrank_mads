//question link - https://www.hackerrank.com/challenges/java-arraylist/problem
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArrayList{

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList <Integer>> al = new ArrayList<ArrayList<Integer>>(n);
        for(int i = 0; i < n; i++){
            int size = sc.nextInt();
            ArrayList<Integer> temp = new ArrayList<Integer>(size);
            for(int j = 0; j < size; j++){
                temp.add(sc.nextInt());
            }
            al.add(temp);
        }
        int num_queries = sc.nextInt();
        int x = 0, y = 0;
        for(int i = 0; i < num_queries; i++){
            x = sc.nextInt();
            y = sc.nextInt();
            if(y > al.get(x-1).size())
                System.out.println("ERROR!");
            else
                System.out.println(al.get(x-1).get(y-1));
        }
    }
}
