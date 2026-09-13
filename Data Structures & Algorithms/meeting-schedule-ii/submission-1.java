class Solution {

    public int minMeetingRooms(List<Interval> intervals) {

        if (intervals == null || intervals.size() == 0) {
            return 0;
        }

        int n = intervals.size();

        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int s = 0;
        int e = 0;

        int rooms = 0;
        int maxRooms = 0;

        while (s < n) {

            if (start[s] < end[e]) {
                // New meeting starts before a meeting ends
                rooms++;

                maxRooms = Math.max(maxRooms, rooms);

                s++;

            } else {
                // Meeting ended, reuse its room
                rooms--;
                e++;
            }
        }

        return maxRooms;
    }
}