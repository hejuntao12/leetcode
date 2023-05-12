package no752;

import java.util.*;

/**
 * @author hjt
 * @date 2021/7/2 12:37
 */
class Solution2 {

    Set<String> visited = new HashSet<>();

    boolean[] dirs = new boolean[]{true, false};

    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }
        Set deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains("0000")) {
            return -1;
        }
        Queue<String> q = new ArrayDeque<>();
        q.offer("0000");
        visited.add("0000");
        int res = 0;
        while (q.size() > 0) {
            res++;
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String curr = q.poll();
                for (int pos = 0; pos < 4; pos++) {
                    for (boolean dir : dirs) {
                        String s = turnOnPos(curr, pos, dir);
                        if (s.equals(target)) {
                            return res;
                        }
                        if (deadSet.contains(s) || visited.contains(s)) {
                            continue;
                        }
                        q.offer(s);
                        visited.add(s);
                    }
                }
            }
        }
        return -1;
    }

    private String turnOnPos(String src, int pos, boolean up) {
        char[] arr = src.toCharArray();
        if (up) {
            if (arr[pos] == '9') {
                arr[pos] = '0';
            } else {
                arr[pos]++;
            }
        } else {
            if (arr[pos] == '0') {
                arr[pos] = '9';
            } else {
                arr[pos]--;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.openLock(new String[]{"0000"}, "8888"));
    }
}
