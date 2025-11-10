import java.util.Scanner;

class ram {

    private static final int MAX_ROUTERS = 100;

    // Function to find the minimum distance vertex in the set of vertices
    private static int minDistance(int[] dist, boolean[] sptSet, int numRouters) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < numRouters; v++) {
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    // Function to print the solution
    private static void printSolution(int[] dist, int numRouters) {
        for (int i = 0; i < numRouters; i++)
            System.out.println(i + " " + dist[i]);
    }

    // Function to implement Dijkstra's algorithm to find the shortest path
    private static void dijkstra(int[][] graph, int src, int numRouters) {
        int[] dist = new int[MAX_ROUTERS];
        boolean[] sptSet = new boolean[MAX_ROUTERS];

        for (int i = 0; i < numRouters; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < numRouters - 1; count++) {
            int u = minDistance(dist, sptSet, numRouters);
            sptSet[u] = true;

            for (int v = 0; v < numRouters; v++) {
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE &&
                    dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        printSolution(dist, numRouters);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numRouters = scanner.nextInt();
        int numLinks = scanner.nextInt();

        int[][] graph = new int[MAX_ROUTERS][MAX_ROUTERS];

        for (int i = 0; i < numLinks; i++) {
            int router1 = scanner.nextInt();
            int router2 = scanner.nextInt();
            int weight = scanner.nextInt();
            graph[router1][router2] = weight;
            graph[router2][router1] = weight;
        }

        int source = scanner.nextInt();
        int destination = scanner.nextInt();

        // Run Dijkstra's algorithm
        dijkstra(graph, source, numRouters);

        scanner.close();
    }
}