package codingTestStudy.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_4485 {
    static int N;
    static int[][] map;             // 각 칸의 도둑루피 크기 저장 배열
    static int[][] rupee;           // 잃게 되는 최소 루피 계산하기 위한 배열
    static boolean[][] visited;     // 방문여부 체크
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int num = 1;

        while (true) {
            N = Integer.parseInt(br.readLine());    // 동굴의 크기
            if (N == 0) break;

            map = new int[N][N];
            rupee = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    // rupee[][] 초기화
                    rupee[i][j] = Integer.MAX_VALUE;
                }
            }

            bfs(0, 0);
            sb.append("Problem " + num++ + ": ").append(rupee[N - 1][N - 1]).append('\n');
        }
        System.out.print(sb);
    }

    static void bfs(int i, int j) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            // 잃는 금액 오름차순 정렬 정의
            return rupee[o1[0]][o1[1]] - rupee[o2[0]][o2[1]];
        });
        pq.add(new int[]{i, j});
        rupee[i][j] = map[i][j];
        visited[i][j] = true;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x < 0 || y < 0 || x >= N || y >= N) continue;
                if (!visited[x][y]) {
                    rupee[x][y] = Math.min(rupee[x][y], rupee[now[0]][now[1]] + map[x][y]);
                    pq.add(new int[]{x, y});
                }
            }
            //**여기서 visited를 true로 설정해준다.
            visited[now[0]][now[1]] = true;
        }
    }
}
