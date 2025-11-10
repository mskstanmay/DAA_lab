Problem Statement

Rekha is a bioinformatician analyzing two DNA sequences to identify all unique longest common subsequences (LCS) between them. This analysis helps in understanding genetic conservation across species.

Write a program to help Rekha find all distinct LCS combinations and print them in the order they are discovered during backtracking, followed by the length of the LCS.

Input format :
The first line of input consists of a string seq1 (first DNA sequence).

The second line of input consists of a string seq2 (second DNA sequence).

Output format :
The first line of output prints: "All possible unique LCS combinations:".

Each subsequent line prints one distinct LCS string.

The last line prints: "Length of LCS: " followed by the integer length.

Refer to the sample output for formatting specifications.

Code constraints :
The given test cases fall under the following constraints:

1 ≤ len(seq1) ≤ 1000

1 ≤ len(seq2) ≤ 1000

The strings contain only uppercase letters (A, C, G, T)

Sample test cases :
Input 1 :
ACG
AGC
Output 1 :
All possible unique LCS combinations:
AC
AG
Length of LCS: 2
Input 2 :
AAAA
ACGA
Output 2 :
All possible unique LCS combinations:
AA
Length of LCS: 2
