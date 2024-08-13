package Greedy;

public class IndianCoins {
    public static void main(String[] args) {
        int[] denominations = {2000,500,100,50,20,10,5,2,1};
        int V = 121;
        int count = 0;
        int value = 0;

        while (V>0) {
            if(V-denominations[value] >= 0){
                count++;
                V -= denominations[value];
            }else{
                value++;
            }
        }
        System.out.println(count);
    }
}
