package tony_git.graph_traversal;

import java.util.*;
import java.awt.Point;
public class B_2178 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++)
                map[i][j] = s.charAt(j) - '0';
        }

        BFS(0, 0);
        System.out.println(map[N-1][M-1]);
    }

    static void BFS(int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = now.x + dx[k];
                int y = now.y + dy[k];
                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (map[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        map[x][y] = map[now.x][now.y] + 1;
                        queue.add(new Point(x, y));
                    }
                }
            }
        }
    }
}
