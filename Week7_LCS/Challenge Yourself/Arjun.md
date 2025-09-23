Problem Statement

Arjun is a computer science student who wants to compare two DNA sequences to find all possible longest common subsequences (LCS) between them. He needs to write a program that takes two strings as input, computes the LCS length, and prints all distinct LCS strings in lexicographical order, followed by the length.

Help Arjun complete this task.

Input format :
The first line of input consists of a string text1 (first DNA sequence).

The second line of input consists of a string text2 (second DNA sequence).

Output format :
The output prints all distinct longest common subsequence strings in lexicographical order, each on a new line.

The last line prints: "The length of the Longest Common Subsequence is: " followed by the integer length.

Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ len(text1) ≤ 1000

1 ≤ len(text2) ≤ 1000

The strings contain only uppercase or lowercase English letters.

Sample test cases :
Input 1 :
This is test
is test This
Output 1 :
is test
The length of the Longest Common Subsequence is: 7
Input 2 :
The brown quick fox
The quick brown fox
Output 2 :
The brown fox
The quick fox
The length of the Longest Common Subsequence is: 13
