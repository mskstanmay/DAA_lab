import java.util.Scanner;

class PrimMST {
    private static final int MAX_V = 10;
    private static final int INF = Integer.MAX_VALUE;

    int minKey(int key[], boolean mstSet[], int V) {
        int min = INF, min_index = -1;

        for (int v = 0; v < V; v++)
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    void printMST(int parent[], int graph[][], int V) {
        System.out.println("Edge   Weight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "    " + graph[i][parent[i]]);
    }

    void primMST(int graph[][], int V) {
        int parent[] = new int[V];
        int key[] = new int[V];
        boolean mstSet[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            key[i] = INF;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet, V);
            mstSet[u] = true;

            for (int v = 0; v < V; v++)
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }

        printMST(parent, graph, V);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();

        int graph[][] = new int[MAX_V][MAX_V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        PrimMST mst = new PrimMST();
        mst.primMST(graph, V);

        scanner.close();
    }
}
