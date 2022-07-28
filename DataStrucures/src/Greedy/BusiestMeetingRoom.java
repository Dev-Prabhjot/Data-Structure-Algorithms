package Greedy;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class BusiestMeetingRoom {

    public static void main(String[] args) {
        int[] i1 = {1, 3};
        int[] i2 = {2, 4};
        int[] i3 = {4, 10};
        int[] i4 = {4, 5};
        int[] i5 = {6, 7};
        System.out.println(findBusiesMeetingRoom(Arrays.asList(i1, i2, i3, i4, i5), 2));
    }

    public static int findBusiesMeetingRoom(List<int[]> intervals, int k) {
        // should make sure intervals are sorted by start time
        // sort by roomId
        PriorityQueue<Room> freeRooms = new PriorityQueue<>((a, b) -> (a.getRoomId() - b.getRoomId()));
        // sort by endTime
        PriorityQueue<Room> bookedRooms = new PriorityQueue<>((a, b) -> (a.getMeetingEndTime() - b.getMeetingEndTime()));

        //Initialize Rooms as per questions ,as at first all rooms are free
        for (int i = 0; i < k; i++) {
            // room id, end time, number of patients
            freeRooms.offer(new Room(i, 0, 0));
        }

        int maxBookings = 0;
        int maxBookingsRoomId = 0;
        int i = 0;
        for (int[] interval : intervals) {
            int startTime = interval[0];
            int endTime = interval[1];

            // pop free rooms from roomsInUse
            while (!bookedRooms.isEmpty() && bookedRooms.peek().getMeetingEndTime() <= startTime) {
                freeRooms.add(bookedRooms.poll());
            }

            if (!freeRooms.isEmpty()) {
                Room room = freeRooms.poll();

                room.setBookings(i++);
                room.setMeetingEndTime(endTime);
                bookedRooms.add(room);

                if (maxBookings < room.getBookings()) {
                    maxBookings = room.getBookings();
                    maxBookingsRoomId = room.getRoomId();
                }

            } else {
                // some exception
            }
        }
        return maxBookingsRoomId;
    }


}
