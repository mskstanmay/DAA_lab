import java.util.*;

public class Sophia {
    static int[][] dp;
    static int[][] split;
    static int n;
    static int[] arr;

    // Function to construct the parenthesization string
    static String buildOrder(int i, int j) {
        if (i == j)
            return "M" + i;
        return "(" + buildOrder(i, split[i][j]) + buildOrder(split[i][j] + 1, j) + ")";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        sc.close();
        // The number of matrices is n-1
        dp = new int[n][n];
        split = new int[n][n];

        for (int i = 1; i < n; i++)
            dp[i][i] = 0;

        for (int len = 2; len < n; len++) {
            for (int i = 1; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        split[i][j] = k;
                    }
                }
            }
        }
        System.out.println(dp[1][n - 1]);
        System.out.println(buildOrder(1, n - 1));
    }
}