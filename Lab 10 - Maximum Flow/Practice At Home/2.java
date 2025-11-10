/*
Problem Statement



Ram has been tasked with optimizing the data transfer in a communication network that consists of several devices. Each device is represented by a vertex, and communication links between devices are represented by directed edges. 



The goal is to find the maximum amount of data that can be efficiently transferred from a source device to a sink device. Ram need to implement the required algorithm to solve this problem. Additionally, the program should output the flow along each edge of the graph.

Input format :
The first line of input consists of single integer v, representing the number of vertices.

The second line of input consists of single integer e, representing the number of edges.

The next e lines consist of pair of vertices (0-based indexing) and their capacities.

Output format :
The first line of output print "Max Flow:" followed by the Max flow.

The Second line of output prints "Flow along each edge:"

The following lines (one per edge with positive flow) print in the format: "Flow from node x to node y: <flow>

where x is the starting node, y is the ending node, and <flow> is the amount of flow along that edge.



Refer to the sample output for the formatting specifications.

Code constraints :
0 ≤ v ≤ 10.

1 ≤ e ≤ 10.

1 ≤ capacities ≤ 100.

Sample test cases :
Input 1 :
6
10
0 1 16
0 2 13
1 2 10
1 3 12
2 1 4
2 4 14
3 2 9
3 5 20
4 3 7
4 5 4
Output 1 :
Max Flow: 23
Flow along each edge:
Flow from node 0 to node 1: 12
Flow from node 0 to node 2: 11
Flow from node 1 to node 3: 12
Flow from node 2 to node 4: 11
Flow from node 3 to node 5: 19
Flow from node 4 to node 3: 7
Flow from node 4 to node 5: 4
Input 2 :
5
8
0 1 10
0 2 5
1 2 15
1 3 10
2 3 5
2 4 10
3 4 10
4 0 15
Output 2 :
Max Flow: 15
Flow along each edge:
Flow from node 0 to node 1: 10
Flow from node 0 to node 2: 5
Flow from node 1 to node 2: 5
Flow from node 1 to node 3: 5
Flow from node 2 to node 4: 10
Flow from node 3 to node 4: 5

*/


import java.util.*;

public class Main {
    static int[][] graph;
    static int[][] residual;
    static int[][] flow;
    static int v;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        v = sc.nextInt();
        int e = sc.nextInt();
        
        graph = new int[v][v];
        residual = new int[v][v];
        flow = new int[v][v];
        
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v1 = sc.nextInt();
            int c = sc.nextInt();
            graph[u][v1] = c;
            residual[u][v1] = c;
        }
        
        int source = 0;
        int sink = v - 1;
        
        int maxFlow = fordFulkerson(source, sink);
        
        System.out.println("Max Flow: " + maxFlow);
        System.out.println("Flow along each edge:");
        printFlows();
    }
    
    static int fordFulkerson(int source, int sink) {
        int[] parent = new int[v];
        int maxFlow = 0;
        
        while (bfs(residual, source, sink, parent)) {
            int pathFlow = Integer.MAX_VALUE;
            
            for (int node = sink; node != source; node = parent[node]) {
                int prev = parent[node];
                pathFlow = Math.min(pathFlow, residual[prev][node]);
            }
            
            for (int node = sink; node != source; node = parent[node]) {
                int prev = parent[node];
                residual[prev][node] -= pathFlow;
                residual[node][prev] += pathFlow;
                flow[prev][node] += pathFlow;
            }
            
            maxFlow += pathFlow;
        }
        
        return maxFlow;
    }
    
    static boolean bfs(int[][] residual, int source, int sink, int[] parent) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(source);
        visited[source] = true;
        parent[source] = -1;
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            
            for (int i = 0; i < v; i++) {
                if (!visited[i] && residual[u][i] > 0) {
                    visited[i] = true;
                    parent[i] = u;
                    queue.add(i);
                    
                    if (i == sink) return true;
                }
            }
        }
        return false;
    }
    
    static void printFlows() {
        for (int u = 0; u < v; u++) {
            for (int v1 = 0; v1 < v; v1++) {
                if (flow[u][v1] > 0) {
                    System.out.println("Flow from node " + u + " to node " + v1 + ": " + flow[u][v1]);
                }
            }
        }
    }
}
