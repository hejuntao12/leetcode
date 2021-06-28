package no46;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, List<Integer> track) {
        if(nums.length == track.size()) {
            res.add(new ArrayList<>(track));
        }
        for(int i : nums) {
            if(track.contains(i)) {
                continue;
            }
            track.add(i);
            backtrack(nums, track);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> r = solution.permute(new int[]{1, 2, 3});
        System.out.println(r);
    }
}
