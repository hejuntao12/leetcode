package no51;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<List<String>> res = new ArrayList<>();

    private char[] emptyLineArr;

    private int num;

    public List<List<String>> solveNQueens(int n) {
        num = n;
        emptyLineArr = new char[n];
        for (int i = 0; i < n; i++) {
            emptyLineArr[i] = '.';
        }
        backtrack(n, new ArrayList<>());
        return res;
    }

    private void backtrack(int n, List<String> track) {
        if (track.size() == n) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(i, track)) {
                continue;
            }
            emptyLineArr[i] = 'Q';
            track.add(new String(emptyLineArr));
            emptyLineArr[i] = '.';
            backtrack(n, track);
            track.remove(track.size() - 1);
        }
    }

    private boolean isValid(int i, List<String> track) {
        for (String line: track) {
            if(line.charAt(i) == 'Q') {
                return false;
            }
        }
        for (int line = track.size()-1, left = i-1; line >= 0 && left >= 0; line--, left--) {
            if(track.get(line).charAt(left) == 'Q') {
                return false;
            }
        }
        for (int line = track.size()-1, right = i+1; line >= 0 && right < num; line--, right++) {
            if(track.get(line).charAt(right) == 'Q'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solveNQueens(4));
    }
}
