class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];
        for (int num : nums) {
            int currentVal = num % k;
            long[] nextDp = new long[k];
            nextDp[currentVal]++;
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int newRem = (r * currentVal) % k;
                    nextDp[newRem] += dp[r];
                }
            }
            for (int r = 0; r < k; r++) {
                result[r] += nextDp[r];
            }
            dp = nextDp;
        }
        return result;
    }
}