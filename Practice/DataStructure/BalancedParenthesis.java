import java.util.*;
class Solution{
    
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            Stack<Character> s = new Stack<Character>();
            int len = str.length(), i = 0;
            boolean balanced = true;
            while(i < len){
                if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '['){
                    s.push(str.charAt(i));
                } 
                else if(!s.empty()){
                    switch(str.charAt(i)){
                        case ']': if(s.peek() == '['){
                            s.pop();
                        }
                        break;
                        case '}': if(s.peek() == '{'){
                            s.pop();
                        }
                        break;
                        case ')' : if(s.peek() == '('){
                            s.pop();
                        }
                    } 
                }
                else{
                    balanced = false;
                    System.out.println(balanced);
                    break;
                }
                i++;
            }
            if(balanced)
                System.out.println(s.empty());   
        }
    }
}
