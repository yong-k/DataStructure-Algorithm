package tony_git.graph_traversal;

// https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-7576%EB%B2%88-%ED%86%A0%EB%A7%88%ED%86%A0-%EC%9E%90%EB%B0%94Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7576 {
    static int M, N;
    static int[][] box;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());

                // 익은 토마토면, 바로 queue에 넣음
                if (box[i][j] == 1)
                    queue.add(new int[]{i, j});
            }
        }

        BFS();

        // 토마토가 익은 일수 중 최댓값
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 안 익은 토마토가 있다면, -1 출력
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(answer, box[i][j]);
            }
        }

        // 익은 날짜: box[i][j] 익은 토마토 기준으로 1부터 시작했으니까, -1 해줌
        System.out.println(answer - 1);
    }

    static void BFS() {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (box[x][y] == 0) {
                        queue.add(new int[]{x, y});
                        box[x][y] = box[now[0]][now[1]] + 1;    // 이전 토마토 익은 날짜 + 1
                    }
                }
            }
        }
    }
}
