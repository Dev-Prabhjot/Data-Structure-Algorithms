package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QueryMeetingPossible {

    public static void main(String args[]) {

//        int start[] = {1, 1,1,3};
//        int end[] = {2, 3,2,4};
        int start[] = {};
        int end[] = {};

        int[][] queries1 = {{3, 4}};
        int[][] queries2 = {{10,20}, {20,30},{5,15}};
        int rooms=3;

//        int start[] = {1,4,6,9,6,1,4};
//        int end[]={3,6,8,11,9,3,10};
//        int [][] queries3={{1, 9}, {2, 6}, {7, 9}, {3, 5}, {3, 9}, {2, 4}, {7, 10}, {5, 9}, {3, 10}, {9, 10}};
//        int rooms=3;

        boolean[] res=maxMeetings(start, end, queries2,1);
        for (boolean x : res) {
            System.out.println(x);
        }

    }

    private static boolean[] maxMeetings(int[] start, int[] end, int[][] queries,int k) {
        List<Integer> startTime=new ArrayList<>();
        List<Integer> endTime=new ArrayList<>();
        boolean[] res=new boolean[queries.length];
        //Add input start time & end time
        for(int i=0;i< start.length;i++)
        {
            startTime.add(start[i]);
            endTime.add(end[i]);
        }

        for(int i=0;i< queries.length;i++)
        {
            startTime.add(queries[i][0]);
            endTime.add(queries[i][1]);
            if(getMeetings(startTime,endTime)<=k)
                res[i]=true;
            else
                res[i]=false;
//
//            startTime.remove(Integer.valueOf(queries[i][0]));
//            endTime.remove(Integer.valueOf(queries[i][1]));
        }


        return res;
    }

    private static int getMeetings(List<Integer> startTime, List<Integer> endTime) {

        int roomsNeeded=1;
        int maxRooms=1;

        startTime=startTime.stream().sorted().collect(Collectors.toList());
        endTime=endTime.stream().sorted().collect(Collectors.toList());

        int i=0,j=i+1;

        while(i<startTime.size() && j<endTime.size())
        {
            if(endTime.get(i)<=startTime.get(j))
            {
                roomsNeeded--;
                i++;
            }else if(endTime.get(i)>startTime.get(i))
            {
                roomsNeeded++;
                j++;
            }

            maxRooms=Math.max(maxRooms,roomsNeeded);
        }

        return maxRooms;
    }
}
