package solutions.easy;

//746: https://leetcode.com/problems/min-cost-climbing-stairs
public class ClimbingStairsMinCost {
    public static void main(String[] args) {
        ClimbingStairsMinCost obj = new ClimbingStairsMinCost();
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return Math.min(dp[n-1], dp[n-2]);
    }
}
