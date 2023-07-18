package no10;

public class Solution2 {

    public static boolean isMatch(String s, String p) {
        if(p.length() == 0) {
            return s.length() == 0;
        }
        if(p.length() > 1 && p.charAt(1) == '*') {
            if(p.charAt(0) == '.') {
                return (s.length() > 0 && isMatch(s.substring(1), p)) || isMatch(s, p.substring(2));
            } else {
                if(s.length() > 0 && s.charAt(0) == p.charAt(0)) {
                    return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
                } else {
                    return isMatch(s, p.substring(2));
                }
            }
        } else {
            if(p.charAt(0) == '.') {
                return s.length() > 0 && isMatch(s.substring(1), p.substring(1));
            } else {
                return s.length() > 0 && s.charAt(0) == p.charAt(0) && isMatch(s.substring(1), p.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isMatch("a", ".*..a*"));
    }
}
