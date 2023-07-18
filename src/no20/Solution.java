package no20;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else if (stack.empty()) {
                return false;
            } else {
                Character pop = stack.pop();
                if(pop+1 != c && pop+2 != c) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        new Solution().isValid("([])");
    }
}
