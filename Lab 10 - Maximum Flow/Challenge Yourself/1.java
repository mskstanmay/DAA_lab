/*
Problem Statement



In a bustling metropolis, a city-wide network infrastructure upgrade is underway to ensure efficient communication between different devices and support the increasing demands of modern technology.



As part of this upgrade, engineers are tasked with optimizing the flow of data through the communication network to maximize its capacity and reliability. 



You are a network engineer responsible for optimizing the data flow in the city's communication network.



Your goal is to calculate the maximum amount of data that can be transferred through the network to ensure efficient communication between different devices, using the maximum flow problem.

Input format :
The first line of the input is a space-separated integer values v and e, specifying the number of vertices and edges.

The next e lines of input consists of space-separated integer values, specifying the source, destination and capacity of each edge.

The last line of the input consists of space-separated integer values, specifying the source and sink.

Output format :
The output prints: "Maximum flow from source to sink is: " followed by an integer value specifying the maximum flow from source to sink.



Refer to sample input for formatting specifications.

Code constraints :
The given test cases fall under the following specifications:

0 ≤ vertices, edge ≤ 10

0 ≤ capacity ≤ 100

Sample test cases :
Input 1 :
3 3
0 1 5
0 2 7 
1 2 3
0 2
Output 1 :
Maximum flow from source to sink is: 10
Input 2 :
4 5
0 1 10
0 2 15
1 3 10
2 1 5
2 3 10
0 3
Output 2 :
Maximum flow from source to sink is: 20

*/

import java.util.*;

class Main {

    static final int V = 6; // number of vertices (fixed as per problem)

    // BFS to check if there is a path from source to sink in residual graph
    static boolean bfs(int[][] rGraph, int s, int t, int[] parent) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        parent[s] = -1;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v = 0; v < V; v++) {
                if (!visited[v] && rGraph[u][v] > 0) {
                    q.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return visited[t];
    }

    // Ford-Fulkerson algorithm (using Edmonds-Karp - BFS)
    static int fordFulkerson(int[][] graph, int s, int t, Map<String, Integer> flowMap) {
        int u, v;
        int[][] rGraph = new int[V][V]; // residual graph
        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];

        int[] parent = new int[V];
        int maxFlow = 0;

        // Augment the flow while there is a path from source to sink
        while (bfs(rGraph, s, t, parent)) {
            int pathFlow = Integer.MAX_VALUE;

            // Find minimum residual capacity in the found path
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                pathFlow = Math.min(pathFlow, rGraph[u][v]);
            }

            // Update residual capacities and reverse edges
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                rGraph[u][v] -= pathFlow;
                rGraph[v][u] += pathFlow;

                // --- START OF CORRECTION ---
                // Check if this is a forward or backward edge
                // We check against the *original* capacity graph
                if (graph[u][v] > 0) {
                    // This is a forward edge. We are ADDING flow to (u -> v).
                    String edge = u + " -> " + v;
                    flowMap.put(edge, flowMap.getOrDefault(edge, 0) + pathFlow);
                } else {
                    // This is a backward edge. We are CANCELLING flow on (v -> u).
                    String edge = v + " -> " + u;
                    // Subtract the flow from the (v -> u) edge
                    flowMap.put(edge, flowMap.getOrDefault(edge, 0) - pathFlow);
                }
                // --- END OF CORRECTION ---
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] graph = new int[V][V];

        // Input adjacency matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        int source = sc.nextInt();
        int sink = sc.nextInt();

        // Use LinkedHashMap to maintain order for easier debugging, 
        // but HashMap would also be correct.
        Map<String, Integer> flowMap = new LinkedHashMap<>();

        // Initialize all potential edges in the flowMap
        // This helps track cancellations correctly even if an edge
        // is cancelled before it's ever used for forward flow.
        // *Correction:* We can just let getOrDefault handle this.
        // We'll use a TreeMap to sort the output keys, matching the sample's order.
        
        // Let's use a TreeMap to get sorted output, which is cleaner
        // and matches the sample output's apparent ordering.
        Map<String, Integer> finalFlowMap = new TreeMap<>();


        fordFulkerson(graph, source, sink, finalFlowMap);

        // Output format
        // --- START OF CORRECTION ---
        // Only print edges that have a final flow > 0
        for (Map.Entry<String, Integer> entry : finalFlowMap.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println("Edge (" + entry.getKey() + "): " + entry.getValue());
            }
        }
        // --- END OF CORRECTION ---

        sc.close();
    }
}


  
