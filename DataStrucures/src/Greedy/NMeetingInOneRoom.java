package Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NMeetingInOneRoom {

    public static void main(String args[]) {
        int n = 7;
        int start[] = {1, 0, 3, 5, 8, 5,9};
        int end[] = {2, 5, 4, 7, 9, 9,10};
        maxMeetings(start, end, n);

    }

    private static List<Integer> maxMeetings(int[] start, int[] end, int n) {
        List<Integer> res = new ArrayList<>();
        List<Meeting> meetingList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetingList.add(new Meeting(start[i], end[i], i + 1));
        }

        meetingList = meetingList.stream()
                .sorted(Comparator.comparing(Meeting::getEnd)
                        .thenComparing(Meeting::getPos)).collect(Collectors.toList());

        int lastMeetingEnd = meetingList.get(0).getEnd();
        res.add(meetingList.get(0).getPos());
        for (int i = 1; i < meetingList.size(); i++) {

            if (meetingList.get(i).getStart() >= lastMeetingEnd) {

                res.add(meetingList.get(i).getPos());
                lastMeetingEnd = meetingList.get(i).getEnd();
            }
        }

        res.forEach(x -> System.out.println(x+","));
        return res;
    }
}
