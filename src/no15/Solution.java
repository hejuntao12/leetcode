package no15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for(int j = i+1, k = nums.length-1; j < k;) {
                if(j > i+1 && nums[j] == nums[j-1]) {
                    j++;
                    continue;
                }
                if(k < nums.length-1 && nums[k] == nums[k+1]) {
                    k--;
                    continue;
                }
                if(nums[j] + nums[k] == -nums[i]) {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if(nums[j] + nums[k] > -nums[i]) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return list;
    }
}
