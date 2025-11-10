import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String seq1 = sc.nextLine().trim();
        String seq2 = sc.nextLine().trim();
        sc.close();

        int m = seq1.length();
        int n = seq2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (seq1.charAt(i - 1) == seq2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lcsLength = dp[m][n];
        // LinkedHashSet preserves insertion order (discovery order)
        Set<String> lcsSet = new LinkedHashSet<>();

        backtrack(seq1, seq2, m, n, dp, new StringBuilder(), lcsSet, lcsLength);

        System.out.println("All possible unique LCS combinations:");
        for (String lcs : lcsSet) {
            System.out.println(lcs);
        }
        System.out.println("Length of LCS: " + lcsLength);
    }

    private static void backtrack(String s1, String s2, int i, int j, int[][] dp, StringBuilder current,
            Set<String> result, int targetLength) {
        if (current.length() == targetLength) {
            // current holds characters in reverse order, create reversed string without mutating current
            String lcs = new StringBuilder(current).reverse().toString();
            result.add(lcs);
            return;
        }

        if (i == 0 || j == 0) {
            return;
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            current.append(s1.charAt(i - 1));
            backtrack(s1, s2, i - 1, j - 1, dp, current, result, targetLength);
            current.deleteCharAt(current.length() - 1);
        } else {
            if (dp[i - 1][j] > dp[i][j - 1]) {
                backtrack(s1, s2, i - 1, j, dp, current, result, targetLength);
            } else if (dp[i][j - 1] > dp[i - 1][j]) {
                backtrack(s1, s2, i, j - 1, dp, current, result, targetLength);
            } else {
                // equal -> explore both; order matters for discovery order
                backtrack(s1, s2, i - 1, j, dp, current, result, targetLength);
                backtrack(s1, s2, i, j - 1, dp, current, result, targetLength);
            }
        }
    }
}

