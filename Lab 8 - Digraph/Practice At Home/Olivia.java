import java.util.*;

class Olivia {
    int v, time;
    List<List<Integer>> adj;
    int disc[];
    int low[];
    boolean instack[];
    Stack<Integer> stack;
    List<List<Integer>> sccs;

    public Olivia(int vertices) {
        v = vertices;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public List<List<Integer>> findSCCs() {
        time = 0;
        disc = new int[v];
        low = new int[v];
        instack = new boolean[v];
        stack = new Stack<>();
        sccs = new ArrayList<>();
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);

        for (int i = 0; i < v; i++) {
            if (disc[i] == -1) {
                tarjanDFS(i);
            }
        }
        return sccs;
    }

    private void tarjanDFS(int u) {
        disc[u] = low[u] = ++time;
        stack.push(u);
        instack[u] = true;

        for (int v : adj.get(u)) {
            if (disc[v] == -1) {
                tarjanDFS(v);
                low[u] = Math.min(low[u], low[v]);
            } else if (instack[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if (low[u] == disc[u]) {
            List<Integer> scc = new ArrayList<>();
            int w;
            do {
                w = stack.pop();
                instack[w] = false;
                scc.add(w);
            } while (w != u);
            sccs.add(scc);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        Olivia graph = new Olivia(V);

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        List<List<Integer>> sccs = graph.findSCCs();

        // Print each SCC in separate line WITHOUT sorting
        for (List<Integer> scc : sccs) {
            // Don't sort - maintain the original order from Tarjan's algorithm
            for (int vertex : scc) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}