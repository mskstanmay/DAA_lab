import java.util.*;

public class Priya {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String genome1 = sc.nextLine();
        String genome2 = sc.nextLine();
        sc.close();
        // First find LCS length and one LCS string
        String lcsString = findLCSString(genome1, genome2);
        int lcsLength = lcsString.length();

        // Then count occurrences of this LCS in genome1
        long occurrenceCount = countSubsequenceOccurrences(genome1, lcsString);

        System.out.println(lcsLength);
        System.out.println(occurrenceCount);
        System.out.println(lcsString);
    }

    public static String findLCSString(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Build LCS length table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Reconstruct LCS string
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.reverse().toString();
    }

    public static long countSubsequenceOccurrences(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        // dp[i][j] = number of times pattern[0..j-1] appears as subsequence in
        // text[0..i-1]
        long[][] dp = new long[n + 1][m + 1];

        // Empty pattern appears once in any text (by not taking any characters)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // Count subsequences without current text character
                dp[i][j] = dp[i - 1][j];

                // If characters match, add count from previous state
                if (text.charAt(i - 1) == pattern.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }

        return dp[n][m];
    }
}