import java.util.*;

class City {
    static final int INF = 1000000; // large value to represent infinity

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // number of locations
        int M = sc.nextInt(); // number of roads

        // Initialize distance matrix
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0; // distance to itself is 0
        }

        // Read roads
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            dist[u][v] = w;
            dist[v][u] = w; // because roads are undirected
        }

        // Floyd-Warshall algorithm
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print final distance matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dist[i][j] >= INF)
                    System.out.print("INF");
                else
                    System.out.print(dist[i][j]);
            }
            System.out.println();
        }
    }
}