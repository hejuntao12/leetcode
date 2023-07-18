package no17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static List<String> charList = new ArrayList<>();
    static{
        charList.add("abc");
        charList.add("def");
        charList.add("ghi");
        charList.add("jkl");
        charList.add("mno");
        charList.add("pqrs");
        charList.add("tuv");
        charList.add("wxyz");
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList();
        for(char c: digits.toCharArray()) {
            if(res.isEmpty()) {
                for(String str: charList.get(c-'2').split("")) {
                   res.add(str);
                }
            } else {
                ArrayList<String> newList = new ArrayList<>();
                for(String prefix: res) {
                    for(String str: charList.get(c-'2').split("")) {
                        newList.add(prefix + str);
                    }
                }
                res = newList;
            }
        }
        return res;
    }
}
