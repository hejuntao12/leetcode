package no11;

class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length-1; i < j;) {
            int current = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(max, current);
            if(height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
