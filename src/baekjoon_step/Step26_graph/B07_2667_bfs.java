package baekjoon_step.Step26_graph;

import java.io.*;
import java.util.*;
public class B07_2667_bfs {
    static int n;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] A;
    static boolean[][] visited;
    static int[] aparts = new int[25*25];
    static int apartNum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                A[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1 && !visited[i][j]) {
                    apartNum++;
                    BFS(i, j);
                }
            }
        }

        System.out.println(apartNum);
        for (int i = 0; i < aparts.length; i++)
            if (aparts[i] != 0)
                System.out.println(aparts[i]);
    }

    static void BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;
        aparts[apartNum]++;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dx[k];
                if (x >= 0 && y >= 0 && x < n && y < n) {
                    if (A[x][y] == 1 && !visited[x][y]) {
                        visited[x][y] = true;
                        q.add(new int[]{x,y});
                        aparts[apartNum]++;
                    }
                }
            }
        }
    }
}
