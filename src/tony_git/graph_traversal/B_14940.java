package tony_git.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_14940 {
    static int n, m;
    static int[][] map;
    static int[][] distance;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        distance = new int[n][m];

        int goalX = 0;
        int goalY = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    goalX = i;
                    goalY = j;
                }
            }
        }

        // 목표지점(2)에서 시작
        BFS(goalX, goalY);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 갈 수 있는 땅인 부분 중 도달할 수 없는 위치는 -1 출력
                if (map[i][j] == 1 && distance[i][j] == 0)
                    sb.append(-1).append(' ');
                else
                    sb.append(distance[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        distance[i][j] = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if (x >= 0 && y >= 0 && x < n && y < m) {
                    if (map[x][y] == 1 && distance[x][y] == 0) {
                        queue.add(new int[]{x, y});
                        distance[x][y] = distance[now[0]][now[1]] + 1;
                    }
                }
            }
        }
    }
}
