import java.util.*;

class CompSci {

    // Function to calculate cost of OBST
    static int optimalBST(int keys[], int freq[], int n) {
        int cost[][] = new int[n][n];

        // Cost for single keys
        for (int i = 0; i < n; i++) {
            cost[i][i] = freq[i];
        }

        // L is chain length
        for (int L = 2; L <= n; L++) {
            for (int i = 0; i <= n - L; i++) {
                int j = i + L - 1;
                cost[i][j] = Integer.MAX_VALUE;

                // sum of freq[i..j]
                int sum = 0;
                for (int s = i; s <= j; s++)
                    sum += freq[s];

                // Try making all keys in interval [i..j] root
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

        int n = sc.nextInt(); // number of keys
        int keys[] = new int[n];
        int freq[] = new int[n];

        for (int i = 0; i < n; i++)
            keys[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            freq[i] = sc.nextInt();
        int r = sc.nextInt(); // key to delete

        // Check if key exists
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (keys[i] == r) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Key not found in the OBST.");
        } else {
            // Remove key and freq at index
            int newKeys[] = new int[n - 1];
            int newFreq[] = new int[n - 1];
            int j = 0;
            for (int i = 0; i < n; i++) {
                if (i != index) {
                    newKeys[j] = keys[i];
                    newFreq[j] = freq[i];
                    j++;
                }
            }

            // Sort keys and keep frequencies aligned
            for (int i = 0; i < newKeys.length - 1; i++) {
                for (int k = i + 1; k < newKeys.length; k++) {
                    if (newKeys[i] > newKeys[k]) {
                        int tempKey = newKeys[i];
                        newKeys[i] = newKeys[k];
                        newKeys[k] = tempKey;
                        int tempFreq = newFreq[i];
                        newFreq[i] = newFreq[k];
                        newFreq[k] = tempFreq;
                    }
                }
            }

            int cost = optimalBST(newKeys, newFreq, n - 1);
            System.out.println("Cost of Optimal BST after deleting the key is " + cost);
        }
        sc.close();
    }
}
