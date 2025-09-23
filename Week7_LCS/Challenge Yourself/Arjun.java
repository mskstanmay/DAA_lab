import java.util.*;

public class Arjun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text1 = sc.nextLine();
        String text2 = sc.nextLine();
        sc.close();
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lcsLength = dp[m][n];
        Set<String> lcsSet = new TreeSet<>();

        if (lcsLength > 0) {
            backtrack(text1, text2, m, n, dp, new StringBuilder(), lcsSet);
        }

        for (String lcs : lcsSet) {
            System.out.println(lcs);
        }
        System.out.println("The length of the Longest Common Subsequence is: " + lcsLength);
    }

    private static void backtrack(String s1, String s2, int i, int j, int[][] dp,
            StringBuilder current, Set<String> result) {
        if (i == 0 || j == 0) {
            if (current.length() == dp[s1.length()][s2.length()]) {
                result.add(current.reverse().toString());
                current.reverse();
            }
            return;
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            current.append(s1.charAt(i - 1));
            backtrack(s1, s2, i - 1, j - 1, dp, current, result);
            current.deleteCharAt(current.length() - 1);
        } else {
            if (dp[i - 1][j] == dp[i][j]) {
                backtrack(s1, s2, i - 1, j, dp, current, result);
            }
            if (dp[i][j - 1] == dp[i][j]) {
                backtrack(s1, s2, i, j - 1, dp, current, result);
            }
        }
    }
}