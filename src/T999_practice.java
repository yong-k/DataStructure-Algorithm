import java.io.*;
import java.util.*;
public class T999_practice {
    static int N, M;
    static int[][] map;
    static int[][] distance;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        distance = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++)
                map[i][j] = s.charAt(j) - '0';
        }

        BFS(0, 0);
        System.out.println(distance[N - 1][M - 1]);
    }

    static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        distance[i][j] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (map[x][y] == 1 && distance[x][y] == 0) {
                        queue.add(new int[]{x, y});
                        distance[x][y] = distance[now[0]][now[1]] + 1;
                    }
                }
            }
        }
    }
}

