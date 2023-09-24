package com.driver;

import java.time.LocalTime;
import java.util.*;

public class Workspace extends Gmail {

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId, Integer.MAX_VALUE);

        calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting) {
        //add the meeting to calendar
        calendar.add(meeting);
    }

    public int findMaxMeetings() {
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        if (calendar.isEmpty())
            return 0;

        List<Meeting> temp = new ArrayList<>(calendar);
        temp.sort(Comparator.comparing(Meeting::getEndTime));

        int count = 1;
        LocalTime lastEndtime = temp.get(0).getEndTime();

        for (int i = 1; i < temp.size(); ++i) {
            Meeting curr = temp.get(i);
            if (curr.getStartTime().isAfter(lastEndtime)) {
                ++count;
                lastEndtime = curr.getEndTime();
            }
        }

        return count;
    }
}