package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Interval {
    public int start;
    public int end;

    public Interval() {
    }

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};


public class EmployeeFreeTime {

    //https://leetcode.com/problems/employee-free-time/
// https://leetcode.com/problems/employee-free-time/discuss/650527/Java-PriorityQueue-loud-and-clear


    public static void main(String[] args) {

        Interval a=new Interval(1,2);
        Interval b=new Interval(5,6);
        Interval c=new Interval(1,3);
        Interval d=new Interval(4,10);

        List<Interval> l1=new ArrayList<>();
        l1.add(a);
        l1.add(b);

        List<Interval> l2=new ArrayList<>();
        l2.add(c);

        List<Interval> l3=new ArrayList<>();
        l3.add(d);

       List<List<Interval>> list= new ArrayList<>();
       list.add(l1);
       list.add(l2);
       list.add(l3);

       employeeFreeTime(list).forEach(x->System.out.println(x.start+" "+x.end));

    }

    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start != b.start ? a.start - b.start : a.end - b.end);

        for (List<Interval> intervals : schedule) {
            for (Interval interval : intervals) {
                pq.offer(interval);
            }
        }

        if (pq.isEmpty()) return res;

        Interval pre = pq.poll();

        while (!pq.isEmpty()) {
            Interval cur = pq.poll();
            if (pre.end < cur.start) {
                res.add(new Interval(pre.end, cur.start));
            } else {
                cur.start = Math.min(pre.start, cur.start);
                cur.end = Math.max(pre.end, cur.end);
            }
            pre = cur;
        }

        return res;
    }


}
