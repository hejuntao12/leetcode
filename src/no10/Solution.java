package no10;

/**
 * 回溯方法
 */
public class Solution {

    public static boolean isMatch(String s, String p) {
        if(p.isEmpty()){
            return s.isEmpty();
        }
        boolean headMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if(p.length() >= 2 && p.charAt(1) == '*'){
            return isMatch(s, p.substring(2)) || (headMatch && isMatch(s.substring(1), p));
        }
        return headMatch && (isMatch(s.substring(1), p.substring(1)));
    }

    public static void main(String[] args) {
        System.out.println(isMatch("", "b*"));
    }
}
