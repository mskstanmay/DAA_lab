import java.util.*;
import java.io.*;

public class Two {
    static int n, m;
    static char[][] grid;
    static boolean[][] visited;
    static final int[] dx = { -1, 1, 0, 0 };
    static final int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        visited = new boolean[n][m];
        int clusterCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    clusterCount++;
                    dfs(i, j, grid[i][j]);
                }
            }
        }
        System.out.println(clusterCount);
    }

    static void dfs(int x, int y, char species) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (!visited[nx][ny] && grid[nx][ny] == species) {
                    dfs(nx, ny, species);
                }
            }
        }
    }
}