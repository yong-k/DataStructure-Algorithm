package baekjoon_step.Step27_graph;

import java.io.*;
import java.util.*;
import java.awt.Point;

public class B_1012_BFS {

    static int M, N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Integer> result = new ArrayList<>();

        for (int k = 0; k < T; k++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            map = new int[M][N];
            visited = new boolean[M][N];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            int count = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        BFS(i, j);
                        count++;
                    }
                }
            }
            result.add(count);
        }
        for (int x : result)
            System.out.println(x);
    }

    static void BFS(int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int k = 0; k < 4; k++) {
                int x = now.x + dx[k];
                int y = now.y + dy[k];
                if (x >= 0 && y >= 0 && x < M && y < N) {
                    if (map[x][y] == 1 && !visited[x][y]) {
                        queue.add(new Point(x, y));
                        visited[x][y] = true;
                    }
                }
            }
        }
    }
}
