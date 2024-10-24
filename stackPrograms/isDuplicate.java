import java.util.Stack;

public class isDuplicate {
    public static void main(String[] args) {
        String s = "((a+b))";
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ')'){
                int count = 0;
                while (stack.peek() != '(') {
                    stack.pop();
                    count++;
                }
                if(count < 1){
                    System.out.println("True");
                    return;
                }else{
                    stack.pop();
                }
            }else{
                stack.push(ch);
            }
        }
        System.out.println("False");
    }
}
