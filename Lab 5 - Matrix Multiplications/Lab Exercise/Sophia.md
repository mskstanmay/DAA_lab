Sophia is managing a data analysis pipeline consisting of multiple computational units represented by matrices. Each unit takes the output from the previous unit as input. Sophia needs to optimize the computational flow by determining the minimum number of scalar multiplications required to process the sequence of matrices.
Additionally, Sophia needs to find the optimal order of matrix multiplications to minimize processing time.
Write a program to help Sophia calculate the minimum cost of matrix multiplications and display the optimal order.
Input format:
The first line contains a single integer n, representing the number of dimensions in the sequence
The second line contains n integers, representing the dimensions of the matrices.
Output format:
The first line of output contains an integer representing the minimum multiplication cost.
The second line of output contains a string representing the optimal order of matrix multiplications, formatted as a nested sequence of matrix multiplications (e.g. (MIM2) or (((MIM2)M3)M4)).
Refer to the sample output for formatting specifications.
Code constraints:
The given test cases fall under the following specifications:
3 ≤ n ≤ 100
1 s dimensions of matrices ≤ 500

Sample test cases:
Input 1:
5
1 2 3 4 5
Input 2:
3
1 2 3
Output 1:
38
(((MIM2)M3)M4)
Output 2:
6
(M1M2)
