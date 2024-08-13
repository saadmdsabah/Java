public class towerofhanoi {

    public static void towerofHanoi(int n,String scr,String help,String dest){
        if(n == 1){
            System.out.println("Transfer of " + n +" from "+ scr + " to "+dest);
            return;
        }
        towerofHanoi(n-1, scr, dest, help);
        System.out.println("Transfer of " + n +" from "+ scr + " to "+dest);
        towerofHanoi(n-1, help, scr, dest);
    }
    public static void main(String[] args) {
        towerofHanoi(2, "S", "H", "D");  
    }
}
