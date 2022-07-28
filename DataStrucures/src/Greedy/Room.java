package Greedy;

public class Room {

    int roomId;
    int meetingEndTime;
    int bookings;

    public Room(int roomId, int meetingEndTime, int bookings) {
        this.roomId = roomId;
        this.meetingEndTime = meetingEndTime;
        this.bookings = bookings;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getMeetingEndTime() {
        return meetingEndTime;
    }

    public void setMeetingEndTime(int meetingEndTime) {
        this.meetingEndTime = meetingEndTime;
    }

    public int getBookings() {
        return bookings;
    }

    public void setBookings(int bookings) {
        this.bookings = bookings;
    }
}
