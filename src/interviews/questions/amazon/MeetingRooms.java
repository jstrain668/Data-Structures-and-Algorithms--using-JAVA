package interviews.questions.amazon;

//Question: Given an array of intervals representing N meetings, find out if a person can attend all the meetings


//A person can not attend two or more meetings at one time. It means if the timings of two meetings are overlapping,
// then she/he will not able to attend it. How to recognize/check that the two meetings are overlapping or not.
// We will use the time interval to check that the meetings are overlapping or not.

//Reference: https://aaronice.gitbook.io/lintcode/sweep-line/meeting-rooms
//Reference: https://massivealgorithms.blogspot.com/2015/08/like-coding-leetcode-252-meeting-rooms.html
//Reference (need a subscription): https://leetcode.com/problems/meeting-rooms/


import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    Interval add(int s, int e){
        return new Interval(s,e);
    }


    // Use the sort method to get all objects sorted - O(nlogn) time complexity. After sorting you go through each
    // object comparing it with the previous object to find if there is an overlap - O(n) time complexity.
    // To sort create anonymous class to execute compare of the start times of each interval to sort them
    // To determine if there are overlapping intervals compare last.end vs. current.start
    // Time complexity: O(nlogn)
    // Space complexity : O(1). Since no additional space is allocated.
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        Interval last = null;
        for (Interval i: intervals) {
            if (last != null && i.start < last.end) {
                return false;
            }
            last = i;
        }
        return true;
    }

    public static void main(String[] args) {
        MeetingRooms mr = new MeetingRooms();
        Interval[] list = new Interval[4];

        list[0] = mr.add(0,30);
        list[1] = mr.add(5,10);
        list[2] = mr.add(15,20);
        list[3] = mr.add(20,22);

        System.out.println("Can I attend all meetings: "+mr.canAttendMeetings(list));

        list[0] = mr.add(5,10);
        list[1] = mr.add(15,20);
        list[2] = mr.add(20,22);
        list[3] = mr.add(22,23);

        System.out.println("Can I attend all meetings: "+mr.canAttendMeetings(list));

        Interval[] list2 = new Interval[3];
        list2[0] = mr.add(7,10);
        list2[1] = mr.add(2,4);
        list2[2] = mr.add(15,20);

        System.out.println("Can I attend all meetings: "+mr.canAttendMeetings(list2));

    }
}
