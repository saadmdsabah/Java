import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {
        String s = "(}";
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i)); 
            }else if((s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') && stack.isEmpty()){
                System.out.println("Invalid");
                return;
            }else if(s.charAt(i) == ')'){
                if(stack.peek() == '(') stack.pop();
                else{
                    System.out.println("Invalid"); 
                    return;
                }
            }else if(s.charAt(i) == ']'){
                if(stack.peek() == '[') stack.pop();
                else{
                    System.out.println("Invalid"); 
                    return;
                }
            }else if(s.charAt(i) == '}'){
                if(stack.peek() == '{') stack.pop();
                else{
                    System.out.println("Invalid"); 
                    return;
                }
            }
        }
        System.out.println(stack.isEmpty());
    }
}
