Problem Statement

A transportation network connects various towns in a region, where each town is represented as a vertex and the roads between them as directed edges (one-way roads). A Strongly Connected Component (SCC) is a maximal subset of towns where every town can reach every other town in the subset by following the directed roads.

Your task is to implement Tarjan's algorithm to identify all strongly connected components in the given transportation network.

Input format :
The first line contains a single integer n representing the number of roads in the network.

The next n lines each contain two integers a and b, representing a one-way road from town a to town b.

The towns are numbered from 0 to the highest town number that appears in the input.

Output format :
First, print all isolated towns (towns with no incoming or outgoing roads), each on a separate line.

Then, print each strongly connected component on a separate line.

For each SCC, list all towns in that component separated by spaces.

The SCCs should be printed in the order they are discovered by Tarjan's algorithm.

Within each SCC, towns should be printed in the order they are processed during the algorithm (the order they are popped from the stack).

Refer to the sample output for the formatting specifications.

Code constraints :
The given test cases fall under the following specifications:

Town numbering starts from 0.

There may be isolated towns in the network (towns with no roads connecting them).

If a town appears in the road list (as either origin or destination), it is not considered isolated.

The order of SCC output follows the standard implementation of Tarjan's algorithm.

0 ≤ towns < 10,000

0 ≤ n ≤ 100,000, where n is the number of roads

Sample test cases :
Input 1 :
3
0 1
1 2
0 2
Output 1 :
2
1
0
Input 2 :
4
0 2
2 3
1 3
0 1
Output 2 :
3
2
1
0
