//To find superset of a set
import java.util.*;
class SuperSet {
    public static void subsets(ArrayList<Integer> A) {
        if(A==null)
            return ;
        int n = A.size();
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        printSubsets(A, result, new ArrayList(),-1);
        System.out.println(result);
        return;
    }

    public static void printSubsets(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int i ){
        if(temp.size() == A.size())
            return;
        for(int j = i + 1 ;j<A.size();j++){
            temp.add(A.get(j));
            result.add(new ArrayList<>(temp));
            printSubsets(A, result, new ArrayList<Integer>(temp), j);
            temp.remove(temp.size()-1);
        }
    }
    

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> a = new ArrayList<Integer>();  
        a.add(1);
        a.add(3);  
        a.add(2);
        //a.add(4);
        subsets(a);
    }
}
