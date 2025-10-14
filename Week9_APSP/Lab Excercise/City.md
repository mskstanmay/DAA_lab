Problem Statement

In a city, there are several locations connected by roads. Each road has a certain distance. You are tasked with finding the shortest distances between all pairs of locations in the city using the Floyd-Warshall algorithm.

Write a program that calculates the shortest path between all pairs of locations in the city.

Example

Input:

4

4

0 1 3

1 2 1

2 3 1

0 2 5

Output:

0 3 4 5

3 0 1 2

4 1 0 1

5 2 1 0

Explanation:

The city has 4 locations (0 to 3).

There are 4 roads connecting the locations.

The roads and their distances are:

0 → 1 with distance 3

1 → 2 with distance 1

2 → 3 with distance 1

0 → 2 with distance 5

Initially, the distance matrix is set to infinity (INF) except for direct roads and diagonal values (0).

The Floyd-Warshall algorithm updates the matrix by checking intermediate paths.

The shortest path from 0 to 2 (via 1) is updated to 4 (0 → 1 → 2) instead of 5.

The shortest path from 0 to 3 is 5 (0 → 1 → 2 → 3).

The final distance matrix is printed, showing the shortest distances.

0 3 4 5

3 0 1 2

4 1 0 1

5 2 1 0

Input format :
The first line contains an integer N, representing the number of locations in the city.

The second line contains an integer M, representing the number of roads in the city.

The next M lines each contain three space-separated integers: u, v, w where:

u and v represent two locations connected by a road.
w represents the distance between u and v.
Output format :
The output prints a matrix, where the value at the i-th row and j-th column represents the shortest distance between location i and location j.

Refer to the sample output for the formatting specifications.

Code constraints :
\In this scenario, the given test cases will fall under the following constraints:

2 ≤ N ≤ 5

1 ≤ M ≤ 10

0 ≤ w ≤ 100

Sample test cases :
Input 1 :
4
4
0 1 3
1 2 1
2 3 1
0 2 5
Output 1 :
0 3 4 5
3 0 1 2
4 1 0 1
5 2 1 0
Input 2 :
3
3
0 1 2
1 2 3
0 2 6
Output 2 :
0 2 5
2 0 3
5 3 0
