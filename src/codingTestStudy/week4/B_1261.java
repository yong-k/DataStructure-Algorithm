package codingTestStudy.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1261 {
    static int N, M;
    static int[][] map;
    static int[][] result;  // 부숴야 하는 벽의 최소 개수 저장
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        result = new int[M][N];

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';

                // result[][] 초기화
                result[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs(0, 0);
        System.out.println(result[M - 1][N - 1]);
    }

    static void bfs(int i, int j) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            // 부숴야 하는 벽 개수 오름차순 정렬 정의
            return result[o1[0]][o1[1]] - result[o2[0]][o2[1]];
        });
        pq.add(new int[]{i, j});
        result[i][j] = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x < 0 || y < 0 || x >= M || y >= N) continue;
                if (result[x][y] == Integer.MAX_VALUE) {
                    if (map[x][y] == 0)
                        result[x][y] = result[now[0]][now[1]];
                    else
                        result[x][y] = Math.min(result[x][y], result[now[0]][now[1]] + 1);
                    pq.add(new int[]{x, y});
                }
            }
        }
    }
}

