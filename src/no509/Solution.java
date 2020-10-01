package no509;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hjt
 * @date 2020/9/30 15:36
 */
class Solution {

    private static Integer[] memo = new Integer[]{0, 1};

    public static int fib(int N) {
        if(N <= 1){
            return memo[N];
        }
        for(int i = 1; i < N; i++){
            int sum = memo[0] + memo[1];
            memo[0] = memo[1];
            memo[1] = sum;
        }
        return memo[1];
    }

    public static void main(String[] args) {
        System.out.println(fib(3));
    }
}
