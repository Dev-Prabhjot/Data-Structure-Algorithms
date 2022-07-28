package Greedy;

public class MeetingRoom {

    int start;
    int end;

    boolean booked;

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    MeetingRoom(int start, int end, boolean status){
        this.start=start;
        this.end=end;
        this.booked=status;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }


    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
