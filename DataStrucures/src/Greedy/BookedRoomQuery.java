package Greedy;

import java.util.ArrayList;
import java.util.List;

public class BookedRoomQuery {

    public static void main(String[] args) {

        int a[]={10,20};
        int b[]={20,30};
        int c[]={5,15};
        int d[]={10,20};
        List<int[]> list=new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);

        for(int[] x:list){
          System.out.println(QueryMeeting(x[0],x[1]));
        }

    }

    static List<MeetingRoom> bookedRoom = new ArrayList<>();

    public static boolean QueryMeeting(int start, int end) {
        if (bookedRoom.isEmpty()) {

            MeetingRoom room = new MeetingRoom(start, end, true);
            bookedRoom.add(room);
            return true;
        } else {
            for(MeetingRoom room:bookedRoom){
                if(room.isBooked() && ((start>= room.getStart() && start<room.getEnd())|| (end>room.getStart() && end<= room.getEnd())))
                {
                    return false;
                }
            }
            bookedRoom.add(new MeetingRoom(start,end,true));
        }
        return true;
    }
}
