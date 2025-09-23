import java.util.*;

public class SubSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = longestIncreasingSubsequence(arr);
        System.out.println("Length of the longest increasing subsequence: " + result);
    }

    public static int longestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return 0;

        int[] dp = new int[n];
        int maxLength = 1;

        // Initialize all LIS lengths to 1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Compute LIS values
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}