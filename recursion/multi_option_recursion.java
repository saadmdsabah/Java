public class multi_option_recursion {

    public static String[] keymap = {".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static void subsequences(String s,int index,String combination){
        if(index == s.length()){
            System.out.println(combination);
            return;
        }
        char currChar = s.charAt(index);
        String mapping = keymap[currChar - '0'];

        for(int i=0;i<mapping.length();i++){
            subsequences(s, index+1, combination+mapping.charAt(i));
        }
    }
    public static void main(String[] args) {
        subsequences("23", 0, "");
    }
}
