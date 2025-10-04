Problem Statement

Selena, a biologist, is studying a 2D habitat map where each cell represents a different species of plants. She needs to determine the number of distinct plant clusters, where a cluster is formed by adjacent cells of the same plant species (connected horizontally or vertically).

Help Selena by writing a program that counts the number of distinct plant clusters in the habitat map.

Input format :
The first line contains an integer n, representing the number of rows in the habitat map.

The second line contains an integer m, representing the number of columns in the habitat map.

The next n lines each contain m characters, where each character represents a species of plant in that cell mat[i][j].

Output format :
The output prints a single integer representing the number of distinct plant clusters in the map.

Refer to the sample output for formatting specifications.

Code constraints :
The given test cases fall under the following specifications:

1 ≤ n, m ≤ 10

1 ≤ mat[i][j] ≤ 10

Sample test cases :
Input 1 :
4
4
aabb
aabb
bbaa
bbaa
Output 1 :
4
Input 2 :
4
2
ab
cb
cc
aa
Output 2 :
4
