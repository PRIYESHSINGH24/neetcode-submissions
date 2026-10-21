
class Solution {
    public int maximumScore(int[] nums, int k) {
        final long MOD = 1_000_000_007L;
        int n = nums.length;

        // Step 1: Calculate prime scores using sieve
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int[] primeScore = new int[maxVal + 1];

        for (int p = 2; p <= maxVal; p++) {
            if (primeScore[p] == 0) {
                for (int multiple = p; multiple <= maxVal; multiple += p) {
                    primeScore[multiple]++;
                }
            }
        }

        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = primeScore[nums[i]];
        }

        // Step 2: Previous index with prime score >= current
        int[] prev = new int[n];
        Arrays.fill(prev, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()
                    && scores[stack.peek()] < scores[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                prev[i] = stack.peek();
            }

            stack.push(i);
        }

        // Step 3: Next index with prime score > current
        int[] next = new int[n];
        Arrays.fill(next, n);
        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty()
                    && scores[stack.peek()] <= scores[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                next[i] = stack.peek();
            }

            stack.push(i);
        }

        // Step 4: Count subarrays selecting each index
        long[] count = new long[n];

        for (int i = 0; i < n; i++) {
            count[i] = (long) (i - prev[i]) * (next[i] - i);
        }

        // Step 5: Sort indices by values in descending order
        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices,
                (a, b) -> Integer.compare(nums[b], nums[a]));

        // Step 6: Calculate maximum score
        long ans = 1;

        for (int i : indices) {
            if (k == 0) {
                break;
            }

            long take = Math.min((long) k, count[i]);

            ans = (ans * modPow(nums[i], take, MOD)) % MOD;

            k -= (int) take;
        }

        return (int) ans;
    }

    // Fast modular exponentiation
    private long modPow(long base, long exp, long mod) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % mod;
            }

            base = base * base % mod;
            exp >>= 1;
        }

        return result;
    }
}