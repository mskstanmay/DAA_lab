import java.util.*;
// You are using Java
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[][]  cost = new int[N][N];
        
        for(int i = 0; i< N; i++){
            for(int j = 0;j<N; j++){
                cost[i][j] =  sc.nextInt();
            }
        }
        
        
        int[]  key = new int[N];
        boolean[] mstset = new boolean[N];
        int[] parent = new int[N];
        
        Arrays.fill(key,Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;
        for(int count = 0; count < N-1;count ++){
            int u = minkey(key,mstset,N);
            mstset[u] = true;
            
            for(int v = 0; v < N;v++){
                if(cost[u][v] != 0 && !mstset[v]  && cost[u][v] < key[v]){
                    parent[v] = u;
                    
                    key[v] = cost[u][v];
                }
            }
        }
        System.out.println("Spanning Tree Matrix:");
        int[][] mstmatrix = new int[N][N];
        int totalcost = 0;
        for(int i  = 1;i<N;i++){
            mstmatrix[i][parent[i]] = cost[i][parent[i]];
            mstmatrix[parent[i]][i] = cost[i][parent[i]];
            totalcost +=cost[i][parent[i]];
        }
        
        for (int i = 0;i<N;i++){
            for (int j = 0;j<N;j++){
                System.out.print(mstmatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Total Cost: " + totalcost);
        
    }
    static int minkey(int[] key, boolean[] mstset, int N){
        int min = Integer.MAX_VALUE,minindex = -1;
        for(int v = 0;v<N;v++){
            if(!mstset[v] && key[v] < min){
                min = key[v];
                minindex = v;
            }
        }
        return minindex;
    } 
    
    
}