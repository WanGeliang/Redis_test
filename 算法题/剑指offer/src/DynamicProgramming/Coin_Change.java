package DynamicProgramming;

import java.util.Arrays;

public class Coin_Change {
    public static void main(String[] args) {
        int[] coins = {2, 5, 7};
        System.out.println(change(coins, 26));
    }

    //动态规划算法
    public static int change(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {//每一个钱包的最小的硬币数量
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {//从硬币中选出来进行抽取
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }

    //test
    public static int coinChange(int[] coins, int amount) {

        //价值每个钱包的数量
        int[] dp = new int[amount + 1];

        //第0个钱包设置为0
        Arrays.fill(dp, 1, dp.length, Integer.MAX_VALUE);

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        if(dp[amount]==Integer.MAX_VALUE) return -1;

        return dp[amount];
    }
}
