package no322;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hjt
 * @date 2020/9/30 17:27
 */
class Solution {


    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        return memoSolution(coins, amount, memo);
    }

    private int memoSolution(int[] coins, int amount,int[] memo){
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        Integer res = memo[amount];
        if(null != res) return res;
        res = Integer.MAX_VALUE;
        for(int coin : coins){
            int sub = memoSolution(coins, amount - coin, memo);
            if(sub == -1) continue;
            res = Math.min(sub + 1, res);
        }
        res = res == Integer.MAX_VALUE ? -1 : res;
        memo[amount] = res;
        return res;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 100;
        Solution solution = new Solution();
        System.out.println(solution.coinChange(coins, amount));
    }
}
