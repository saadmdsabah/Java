package Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing {

    public static class Job {
        int deadline;
        int profit;
        public Job(int deadline, int profit){
            this.deadline = deadline;
            this.profit = profit;
        }
    }
    public static void main(String[] args) {
        int jobsInfo[][] = {{4,20},{1,10},{1,40},{1,30}};
        ArrayList<Job> list = new ArrayList<>();
        for(int i[] : jobsInfo){
            list.add(new Job(i[0], i[1]));
        }

        Collections.sort(list, (a,b) -> b.profit - a.profit);

        int time = 0;
        int profit = 0;
        for(Job j : list){
            if(j.deadline > time){
                profit += j.profit;
                time++;
            }
        }
        System.out.println(profit);
    }
}
