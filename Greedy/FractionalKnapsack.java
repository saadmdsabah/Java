package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] weight = {10,20,30};
        int[] value = {60,100,120};

        int[][] table = new int[weight.length][3];
        for(int i=0; i<weight.length; i++){
            table[i][0] = weight[i];
            table[i][1] = value[i];
            table[i][2] = value[i]/weight[i];
        }

        double profit = 0;
        int W = 50;
        Arrays.sort(table, Comparator.comparingDouble(o -> o[2]));
        for(int i=table.length-1; i>=0 && W>0; i--){
            if(W < table[i][0]){
                profit += ((double)W/table[i][0])*table[i][1];
                W = 0;
            }else{
                profit += table[i][1];
                W -= table[i][0];
            }
        }
        System.out.println(profit);
    }   
}
