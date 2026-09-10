
class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        // Sort meetings by start time
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        // Check for overlapping meetings
        for (int i = 1; i < intervals.size(); i++) {

            if (intervals.get(i).start < intervals.get(i - 1).end) {
                return false;
            }
        }

        return true;
    }
}