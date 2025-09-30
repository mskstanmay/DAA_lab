import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] keys = new int[n];
        int[] freq = new int[n];
        int[] prob = new int[n + 1];

        for (int i = 0; i < n; i++) {
            keys[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            freq[i] = scanner.nextInt();
        }
        for (int i = 0; i < n + 1; i++) {
            prob[i] = scanner.nextInt();
        }

        int[][] W = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            W[i][i] = prob[i];
        }

        for (int length = 1; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length;
                W[i][j] = W[i][j - 1] + freq[j - 1] + prob[j];
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                System.out.print(W[i][j]);
                if (j < n) {
                    System.out.print(" ");
                }
            }
            if (i < n) {
                System.out.println();
            }
        }

        scanner.close();
    }
}