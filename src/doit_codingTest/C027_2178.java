package doit_codingTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class C027_2178 {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        BFS(0, 0);
        System.out.println(map[N - 1][M - 1]);
    }

    static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[i][j] = true;

            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x < 0 || y < 0 || x >= N || y >= M) continue;
                if (map[x][y] != 0 && !visited[x][y]) {
                    visited[x][y] = true;
                    map[x][y] = map[now[0]][now[1]] + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
    }
}
