Problem Statement

Priya is a genetic researcher studying viral mutations. She has two DNA sequences and wants to find the longest common subsequence (LCS) between them. Additionally, she needs to know how many times this LCS appears as a subsequence in the first genome. Help Priya by writing a program to compute the length of the LCS, the count of its occurrences in the first genome, and the LCS string itself.

Input format :
The first line of input consists of a string genome1 (the first DNA sequence).

The second line of input consists of a string genome2 (the second DNA sequence).

Output format :
The first line of output prints an integer lcs_length (the length of the LCS).

The second line of output prints a long integer occurrence_count (the number of times the LCS appears as a subsequence in genome1).

The third line of output prints a string lcs_string (the longest common subsequence).

Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ len(genome1) ≤ 1000

1 ≤ len(genome2) ≤ 1000

The strings contain only uppercase letters (A, C, G, T).

Sample test cases :
Input 1 :
ABCDGH
AEDFHR
Output 1 :
3
1
ADH
Input 2 :
AAAAAA
AAXAAA
Output 2 :
5
6
AAAAA
