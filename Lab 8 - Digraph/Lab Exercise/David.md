Problem Statement

David, a network administrator, wants to analyze the connectivity of a set of servers. Given a directed network of servers, he needs to identify groups of servers that are strongly connected, meaning there is a path between every pair of servers in both directions.

Help David by writing a program that determines these strongly connected components.

Example

Input:

5

5

1 3

1 4

2 1

3 2

4 5

Output:

Strongly Connected Components are:

1 2 3

4

5

Explanation:

There are 5 vertices and 5 edges.

1 → 3 → 2

↑ ↓

| |

2 4 → 5

SCC 1: {1, 2, 3}

1 → 3 → 2 → 1 forms a cycle (reachable in both directions).

SCC 2: {4}

4 → 5 but 5 cannot reach 4, so 4 is its own SCC.

SCC 3: {5}

No outgoing edges from 5, so it forms an SCC alone.

Strongly Connected Components are:

1 2 3

4

5

Input format :
The first line of input consists of an integer V, representing the number of servers (nodes).

The second line consists of an integer E, representing the number of direct connections (edges) between the servers.

The next E lines each contain two integers u and v, representing a directed connection from server u to server v.

Output format :
The output prints "Strongly Connected Components are:" followed by multiple lines.

Each line contains a space-separated list of integers representing the nodes in one strongly connected component.

Refer to the sample output for formatting specifications.

Code constraints :
The given test cases fall under the following specifications:

1 ≤ V ≤ 10

1 ≤ E ≤ 10

Sample test cases :
Input 1 :
4
4
1 2
2 3
3 4
4 1
Output 1 :
Strongly Connected Components are:
1 2 3 4
Input 2 :
5
5
1 3
1 4
2 1
3 2
4 5
Output 2 :
Strongly Connected Components are:
1 2 3
4
5
