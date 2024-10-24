import java.util.Stack;

public class NextGreatest {
    public static void main(String[] args) {
        int[] array = {6,8,0,1,3,1,4,6};
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[array.length];
        int j = result.length-1;

        for(int i=array.length-1; i>=0; i--){
            if(stack.isEmpty()){
                result[j--] = -1;
            }else{
                if(stack.peek() > array[i]){
                    result[j--] = stack.peek();
                }else{
                    while (!stack.isEmpty() && stack.peek() <= array[i]) {
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                        result[j--] = -1;
                    }else{
                        result[j--] = stack.peek();
                    }
                }
            }
            stack.push(array[i]);
        }
        for(int i : result){
            System.out.print(i + " ");
        }
    }
}
