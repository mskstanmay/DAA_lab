Emily is managing a factory that operates on sequential machines represented by matrices. Each machine outputs data in a format that matches the input dimensions of the next machine. To reduce processing time, Emily wants to determine the minimum number of scalar operations required to process the sequence.
Additional Constraint: It should display the optimal order of the Multiplication.
Help Emily to complete the task.
Input format:
The first line contains a single integer n, representing the number of dimensions in the array
The second line contains n integers, representing the dimensions of the matrices.
Output format:
The first line of output prints the minimum cost of matrix multiplication.
The second line prints the optimal order of matrix multiplications in the form of nested parentheses (e.g., (((MIM2)M3)M4)).
Refer to the sample output for formatting specifications.
Code constraints:
The given test cases fall under the following specifications:
3 ≤ n ≤ 100
1s dimensions of matrices s 500

Sample test cases:
Input 1:
5
1 2 3 4 3
Output 1:
30
(((M1M2)M3)M4)
Input 2:
3
10 20 30
Output 2:
6000 (M1M2)
