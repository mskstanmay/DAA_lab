import java.util.*;

class RoadNetwork {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> reverseGraph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            reverseGraph.get(v).add(u);
        }

        int result = minAdditionalStreets(n, graph, reverseGraph);
        System.out.println(result);

        sc.close();
    }

    private static int minAdditionalStreets(int n, List<List<Integer>> graph, List<List<Integer>> reverseGraph) {
        // Step 1: Find SCCs using Kosaraju's algorithm
        boolean[] visited = new boolean[n + 1];
        Stack<Integer> stack = new Stack<>();

        // First DFS on original graph
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited, stack);
            }
        }

        // Find SCCs
        Arrays.fill(visited, false);
        List<List<Integer>> sccs = new ArrayList<>();
        int[] sccId = new int[n + 1];
        int sccCount = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                List<Integer> scc = new ArrayList<>();
                dfsReverse(node, reverseGraph, visited, scc);
                for (int vertex : scc) {
                    sccId[vertex] = sccCount;
                }
                sccs.add(scc);
                sccCount++;
            }
        }

        // If the graph is already strongly connected
        if (sccCount == 1) {
            return 0;
        }

        // Build condensation graph
        Set<Integer>[] condensationGraph = new Set[sccCount];
        int[] inDegree = new int[sccCount];
        int[] outDegree = new int[sccCount];

        for (int i = 0; i < sccCount; i++) {
            condensationGraph[i] = new HashSet<>();
        }

        for (int u = 1; u <= n; u++) {
            for (int v : graph.get(u)) {
                int sccU = sccId[u];
                int sccV = sccId[v];
                if (sccU != sccV && !condensationGraph[sccU].contains(sccV)) {
                    condensationGraph[sccU].add(sccV);
                    outDegree[sccU]++;
                    inDegree[sccV]++;
                }
            }
        }

        // Count source and sink components
        int sources = 0, sinks = 0;
        for (int i = 0; i < sccCount; i++) {
            if (inDegree[i] == 0)
                sources++;
            if (outDegree[i] == 0)
                sinks++;
        }

        // Minimum additional edges needed is max(sources, sinks)
        return Math.max(sources, sinks);
    }

    private static void dfs(int node, List<List<Integer>> graph, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, stack);
            }
        }
        stack.push(node);
    }

    private static void dfsReverse(int node, List<List<Integer>> reverseGraph, boolean[] visited,
            List<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int neighbor : reverseGraph.get(node)) {
            if (!visited[neighbor]) {
                dfsReverse(neighbor, reverseGraph, visited, component);
            }
        }
    }
}