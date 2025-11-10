
import java.util.*;

class Alya {

    static int optimalBST(int keys[], int freq[], int n) {
        int cost[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            cost[i][i] = freq[i];
        }

        for (int L = 2; L <= n; L++) {
            for (int i = 0; i <= n - L; i++) {
                int j = i + L - 1;
                cost[i][j] = Integer.MAX_VALUE;

                int sum = 0;
                for (int s = i; s <= j; s++)
                    sum += freq[s];

                for (int r = i; r <= j; r++) {
                    int c = ((r > i) ? cost[i][r - 1] : 0) +
                            ((r < j) ? cost[r + 1][j] : 0) +
                            sum;
                    if (c < cost[i][j]) {
                        cost[i][j] = c;
                    }
                }
            }
        }
        return cost[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int keys[] = new int[n];
        int freq[] = new int[n];

        for (int i = 0; i < n; i++)
            keys[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            freq[i] = sc.nextInt();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (keys[i] > keys[j]) {
                    int tempKey = keys[i];
                    keys[i] = keys[j];
                    keys[j] = tempKey;
                    int tempFreq = freq[i];
                    freq[i] = freq[j];
                    freq[j] = tempFreq;
                }
            }
        }

        int cost = optimalBST(keys, freq, n);
        System.out.println("Cost of Optimal BST is " + cost);

        sc.close();
    }
}
