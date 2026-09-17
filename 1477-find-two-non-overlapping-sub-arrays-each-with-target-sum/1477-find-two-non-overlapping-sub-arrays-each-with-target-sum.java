import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLen = new int[n];
        Arrays.fill(minLen, Integer.MAX_VALUE);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int currSum = 0;
        int minSoFar = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            currSum += arr[i];
            if (map.containsKey(currSum - target)) {
                int prevIdx = map.get(currSum - target);
                int currentLen = i - prevIdx;
                if (prevIdx >= 0 && minLen[prevIdx] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, currentLen + minLen[prevIdx]);
                }
                minSoFar = Math.min(minSoFar, currentLen);
            }
            minLen[i] = minSoFar;
            map.put(currSum, i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}