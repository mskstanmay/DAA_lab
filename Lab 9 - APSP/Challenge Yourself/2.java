import java.util.Scanner;

class FloydWarshallAlgorithm {

    static final int V = 4;
    static final int INF = 99999;

    static void printSolution(int[][] dist, int[][] next) {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }

        System.out.println("Shortest paths between every pair of vertices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i != j && next[i][j] != -1) {
                    System.out.print("Shortest path from node " + i + " to node " + j + ": " + i);
                    int nextNode = next[i][j];
                    while (nextNode != j) {
                        System.out.print(" -> " + nextNode);
                        nextNode = next[nextNode][j];
                    }
                    System.out.println(" -> " + j);
                }
            }
        }
    }

    static void floydWarshall(int[][] graph) {
        int[][] dist = new int[V][V];
        int[][] next = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != INF && i != j) {
                    next[i][j] = j;
                } else {
                    next[i][j] = -1;
                }
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        printSolution(dist, next);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] graph = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        floydWarshall(graph);
        scanner.close();
    }
}