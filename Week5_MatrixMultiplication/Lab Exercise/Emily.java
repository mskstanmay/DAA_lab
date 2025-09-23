import java.util.*;

public class Emily {
    static int[][] dp;
    static int[][] bracket;
    static int n;
    static int[] arr;

    // Function to print optimal parenthesization
    static String printOptimal(int i, int j) {
        if (i == j) {
            return "M" + i;
        }
        return "(" + printOptimal(i, bracket[i][j]) + printOptimal(bracket[i][j] + 1, j) + ")";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        sc.close();
        dp = new int[n][n];
        bracket = new int[n][n];

        for (int i = 1; i < n; i++)
            dp[i][i] = 0;

        // l is chain length
        for (int l = 2; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    if (q < dp[i][j]) {
                        dp[i][j] = q;
                        bracket[i][j] = k;
                    }
                }
            }
        }
        System.out.println(dp[1][n - 1]);
        System.out.println(printOptimal(1, n - 1));
    }
}