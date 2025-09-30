import java.util.*;

public class David {
    static int V;
    static List<List<Integer>> adj = new ArrayList<>();
    static List<List<Integer>> revAdj = new ArrayList<>();
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        int E = sc.nextInt();

        // Initialize adjacency lists for original and reverse graphs
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
            revAdj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            revAdj.get(v).add(u);
        }

        visited = new boolean[V + 1];
        // First DFS to fill stack according to finish times
        for (int i = 1; i <= V; i++) {
            if (!visited[i])
                dfs1(i);
        }

        Arrays.fill(visited, false);

        List<List<Integer>> allSCCs = new ArrayList<>();
        // Process vertices in order defined by stack to get SCCs
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                List<Integer> scc = new ArrayList<>();
                dfs2(node, scc);
                Collections.sort(scc); // Sort SCC nodes for neat output
                allSCCs.add(scc);
            }
        }

        // Sort SCCs by smallest node to ensure consistent output order
        Collections.sort(allSCCs, Comparator.comparingInt(a -> a.get(0)));

        // Print the output as per requirement
        System.out.println("Strongly Connected Components are:");
        for (List<Integer> scc : allSCCs) {
            for (int num : scc) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // DFS for order stack filling in original graph
    static void dfs1(int node) {
        visited[node] = true;
        for (int neigh : adj.get(node)) {
            if (!visited[neigh])
                dfs1(neigh);
        }
        stack.push(node);
    }

    // DFS to collect nodes for one SCC from reversed graph
    static void dfs2(int node, List<Integer> scc) {
        visited[node] = true;
        scc.add(node);
        for (int neigh : revAdj.get(node)) {
            if (!visited[neigh])
                dfs2(neigh, scc);
        }
    }
}