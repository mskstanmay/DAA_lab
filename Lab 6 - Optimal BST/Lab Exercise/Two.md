Problem Statement

Implement a program to construct an optimal binary search tree (OBST) given a set of keys and their frequencies. The program should calculate the cost matrix for the OBST.

Input format :
The first line contains an integer N, the number of keys in the tree.

The next line contains N integers, representing the keys.

The following line contains N integers, representing the frequencies of the keys.

The last line contains N + 1 integers, representing the probabilities of unsuccessful searches.

Output format :
The output displays the cost matrix C, where C represents the cost of the subtree.

Each row of the matrix should be printed on a new line, with elements separated by spaces.

Refer to the sample output for the exact format.

Code constraints :
1 ≤ N ≤ 10

1 ≤ Keys, frequencies, and probabilities ≤ 103

Sample test cases :
Input 1 :
3
10 20 30
1 1 2
1 2 1 2
Output 1 :
1 7 14 25
2 7 17
1 8
2
Input 2 :
3
10 20 30
3 1 6
1 2 3 4
Output 2 :
1 9 22 46
2 11 31
3 20
4
