package src.easy;

import java.util.*;

public class MinimumMovesToOneDP {

    public static int minMovesDP(int N) {
        int[] dp = new int[N + 1];
        dp[1] = 0; // Base case: 1 soldier requires 0 moves

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; // Default: subtract 1

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1); // Divide by 2
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1); // Divide by 3
            }
        }

        return dp[N];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(minMovesDP(N));
    }
}

