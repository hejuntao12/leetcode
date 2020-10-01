package no509;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hjt
 * @date 2020/9/30 17:18
 */
public class Solution2 {

    private static Map<Integer, Integer> memo = new HashMap<>();

    public int fib(int N) {
        if(N <= 1){
            return N;
        }
        return memo.computeIfAbsent(N, k -> fib(N-1) + fib(N-2));
    }
}
