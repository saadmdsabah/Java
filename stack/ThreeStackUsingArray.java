public class ThreeStackUsingArray {

    static int[] stack = new int[12];
    static int n = stack.length-1;
    static int first1 = -1;
    static int first2 = -1;
    static int first3 = -1;
    static int last1 = -1;
    static int last2 = -1;
    static int last3 = -1;

    public static void isEmpty(int stackNumber){
        if(stackNumber == 1 && last1 == -1){
            System.out.println(true);
            return;
        }else if(stackNumber == 2 && last2 == -1){
            System.out.println(true);
            return;
        }else if(stackNumber == 3 && last3 == -1){
            System.out.println(true);
            return;
        }
        System.out.println(false);
    }

    public static void isFull(int stackNumber){
        if(stackNumber == 1 && last1 == n-1){
            System.out.println(true);
        }else if(stackNumber == 2 && last2 == n-1){
            System.out.println(true);
        }else if(stackNumber == 3 && last3 == n-1){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }

    public static void push(int stackNumber, int data){
        if(stackNumber == 1){
            if(last1 == -1){
                last1 = 0;
                first1 = 0;
                stack[last1] = data;
                System.out.println("Pushed " + data + " in the stack number " + stackNumber);
                return;
            }else if(last1 == 3){
                System.out.println("The Stack number " +stackNumber + " is Full cannot add elements to it");
                return;
            }
            System.out.println("Pushed " + data + " in the stack number " + stackNumber);
            last1 += 1;
            stack[last1] = data;
        }else if(stackNumber == 2){
            if(last2 == -1){
                last2 = 4;
                first2 = 4;
                stack[last2] = data;
                System.out.println("Pushed " + data + " in the stack number " + stackNumber);
                return;
            }else if(last2 == 7){
                System.out.println("The Stack number " +stackNumber + " is Full cannot add elements to it");
                return;
            }
            System.out.println("Pushed " + data + " in the stack number " + stackNumber);
            last2 += 1;
            stack[last2] = data;
        }else if(stackNumber == 11){
            if(last3 == -1){
                last3 = 8;
                first3 = 8;
                stack[last3] = data;
                System.out.println("Pushed " + data + " in the stack number " + stackNumber);
                return;
            }else if(last3 == n-1){
                System.out.println("The Stack number " +stackNumber + " is Full cannot add elements to it");
                return;
            }
            System.out.println("Pushed " + data + " in the stack number " + stackNumber);
            last3 += 1;
            stack[last3] = data;
        }
    }

    public static void top(int stackNumber){
        if(stackNumber == 1 && last1 == -1){
            System.out.println("The stack number " + stackNumber +" is empty hence no top element");
        }else if(stackNumber == 2 && last2 == -1){
            System.out.println("The stack number " + stackNumber +" is empty hence no top element");
        }else if(stackNumber == 3 && last3 == -1){
            System.out.println("The stack number " + stackNumber +" is empty hence no top element");
        }else if(stackNumber == 1){
            System.out.println(stack[last1] + " is the top element of the stack number " + stackNumber);
        }else if(stackNumber == 2){
            System.out.println(stack[last1] + " is the top element of the stack number " + stackNumber);
        }else if(stackNumber == 3){
            System.out.println(stack[last1] + " is the top element of the stack number " + stackNumber);
        }
    }

    public static void main(String[] args) {
        push(1, 11);
        top(1);
        push(1, 5);
        top(1);
        push(2, 5);
        push(2, 10);
        push(2, 3);
        push(2, -1);
        push(2, 0);
        top(2);
        top(3);
    }   
}
