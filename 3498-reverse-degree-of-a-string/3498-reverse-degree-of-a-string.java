class Solution {
    public int reverseDegree(String s) {
        int totalDegree = 0;     
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int reversedVal = 26 - (c - 'a');
            int stringIndex = i + 1;
            totalDegree += reversedVal * stringIndex;
        }
        return totalDegree;
    }
}