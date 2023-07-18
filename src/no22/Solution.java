package no22;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public List<String> generateParenthesis(int n) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.isEmpty()) {
                set.add("()");
            } else {
                Set<String> newSet = new HashSet<>();
                set.forEach(e -> {
                    newSet.add("()" + e);
                    newSet.add("(" + e + ")");
                    newSet.add(e + "()");
                });
                set = newSet;
            }
        }
        return set.stream().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(4));
    }
}
