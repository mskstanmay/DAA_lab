import java.util.*;

public class Two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] keys = new int[n];
        int[] freq = new int[n];
        int[] dummy = new int[n + 1];
        for (int i = 0; i < n; i++)

            keys[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            freq[i] = sc.nextInt();
        for (int i = 0; i <= n; i++)
            dummy[i] = sc.nextInt();
        int[][] cost = new int[n + 2][n + 1];
        int[][] weight = new int[n + 2][n + 1];
        for (int i = 1; i <= n + 1; i++) {
            cost[i][i - 1] = dummy[i - 1];
            weight[i][i - 1] = dummy[i - 1];
        }
        for (int l = 1; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                cost[i][j] = Integer.MAX_VALUE;
                weight[i][j] = weight[i][j - 1] + freq[j - 1] + dummy[j];
                for (int r = i; r <= j; r++) {
                    int temp = cost[i][r - 1] + cost[r + 1][j] + weight[i][j];
                    if (temp < cost[i][j]) {
                        cost[i][j] = temp;
                    }
                }
            }
        }
        for (int i = 1; i <= n + 1; i++) {
            for (int j = i - 1; j <= n; j++) {
                System.out.print(cost[i][j] + " ");
            }
            System.out.println();
        }
    }
}