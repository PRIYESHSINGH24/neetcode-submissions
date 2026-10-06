class Solution {
    public int[] findBuildings(int[] heights) {
        // Traverse from end of array and capture the indexes that are curr max.
        // as we traverse from right to left, only the taller building on left will have ocean view 
        int max = 0, i=heights.length-1;
        List<Integer> ans = new ArrayList<>();
        while(i >= 0) {
            if (max < heights[i]) {
                max = heights[i];
                ans.add(i);
            }
            i--;
        }
        Collections.reverse(ans);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}