class Solution {

    public int findMinDifference(String[] timePoints) {

        int[] minutes = new int[timePoints.length];

        for (int i = 0; i < timePoints.length; i++) {
            String time = timePoints[i];

            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3));

            minutes[i] = h * 60 + m;
        }

        Arrays.sort(minutes);

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < minutes.length - 1; i++) {
            ans = Math.min(ans, minutes[i + 1] - minutes[i]);
        }

        return Math.min(
            ans,
            1440 - minutes[minutes.length - 1] + minutes[0]
        );
    }
}