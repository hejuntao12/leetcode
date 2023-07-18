package no3;

import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(set.contains(c)) {
                while(true) {
                    char startCh = s.charAt(start);
                    start++;
                    if(startCh != c) {
                        set.remove(startCh);
                    } else {
                        break;
                    }
                }
            } else {
                set.add(c);
                max = set.size() > max ? set.size() : max;
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int start = 0, end = 0;
        while(end < s.length()) {
            char c = s.charAt(end);
            if (set.contains(c)) {
                set.remove(s.charAt(start++));
            } else {
                set.add(s.charAt(end++));
                max = set.size() > max ? set.size() : max;
            }
        }
        return max;
    }
}
