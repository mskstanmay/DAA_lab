import java.util.*;

public class Rekha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String seq1 = sc.nextLine();
        String seq2 = sc.nextLine();
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
        Set<String> lcsSet = new HashSet<>();

        backtrack(seq1, seq2, m, n, dp, new StringBuilder(), lcsSet);

        System.out.println("All possible unique LCS combinations:");
        for (String lcs : lcsSet) {
            System.out.println(lcs);
        }
        System.out.println("Length of LCS: " + lcsLength);
    }

    private static void backtrack(String s1, String s2, int i, int j, int[][] dp, StringBuilder current,
            Set<String> result) {
        if (i == 0 || j == 0) {
            String lcs = current.reverse().toString();
            current.reverse();
            if (lcs.length() == dp[s1.length()][s2.length()]) {
                result.add(lcs);
            }
            return;
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            current.append(s1.charAt(i - 1));
            backtrack(s1, s2, i - 1, j - 1, dp, current, result);
            current.deleteCharAt(current.length() - 1);
        } else {
            if (dp[i - 1][j] > dp[i][j - 1]) {
                backtrack(s1, s2, i - 1, j, dp, current, result);
            } else if (dp[i][j - 1] > dp[i - 1][j]) {
                backtrack(s1, s2, i, j - 1, dp, current, result);
            } else {
                backtrack(s1, s2, i - 1, j, dp, current, result);
                backtrack(s1, s2, i, j - 1, dp, current, result);
            }
        }
    }
}