package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};

        // If not Sorted
        int[][] activities = new int[start.length][3];

        // Create a table of the activities
        for(int i=0; i<start.length; i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // Sort the Table based on columns 2
        Arrays.sort(activities,Comparator.comparingDouble(o -> o[2]));

        int count = 1;
        int previousActivity = activities[0][2];

        for(int i=1; i<activities.length; i++){
            if(activities[i][1] >= previousActivity){
                count++;
                previousActivity = activities[i][2];
            }
        }
        System.out.println(count);

        // If Already Sorted in End Positions
        count = 1;
        previousActivity = end[0];

        for(int i=1; i<start.length; i++){
            if(start[i] >= previousActivity){
                count++;
                previousActivity = end[i];
            }
        }
        System.out.println(count);
    }
}
