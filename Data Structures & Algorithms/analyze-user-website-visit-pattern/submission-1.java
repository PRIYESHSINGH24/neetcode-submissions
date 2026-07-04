
class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

        int n = username.length;

        // Step 1: Sort by timestamp
        List<int[]> order = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            order.add(new int[]{timestamp[i], i});
        }

        Collections.sort(order, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Build website list for each user
        Map<String, List<String>> userMap = new HashMap<>();

        for (int[] x : order) {
            int idx = x[1];
            userMap.computeIfAbsent(username[idx], k -> new ArrayList<>())
                   .add(website[idx]);
        }

        // Step 3: Count unique patterns
        Map<String, Integer> count = new HashMap<>();

        for (String user : userMap.keySet()) {
            List<String> sites = userMap.get(user);
            int m = sites.size();

            if (m < 3) continue;

            Set<String> seen = new HashSet<>();

            for (int i = 0; i < m - 2; i++) {
                for (int j = i + 1; j < m - 1; j++) {
                    for (int k = j + 1; k < m; k++) {

                        String pattern = sites.get(i) + "," +
                                         sites.get(j) + "," +
                                         sites.get(k);

                        if (seen.add(pattern)) {
                            count.put(pattern,
                                    count.getOrDefault(pattern, 0) + 1);
                        }
                    }
                }
            }
        }

        // Step 4: Find best pattern
        String best = "";
        int max = 0;

        for (String pattern : count.keySet()) {
            int freq = count.get(pattern);

            if (freq > max ||
                (freq == max && pattern.compareTo(best) < 0)) {

                max = freq;
                best = pattern;
            }
        }

        return Arrays.asList(best.split(","));
    }
}