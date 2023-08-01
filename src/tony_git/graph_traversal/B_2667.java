package tony_git.graph_traversal;

import java.io.*;
import java.util.*;
public class B_2667 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int houseCnt;    // 단지 내 가구 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++)
                map[i][j] = s.charAt(j) - '0';
        }

        int townCnt = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    houseCnt = 1;
                    BFS(i, j);
                    result.add(houseCnt);
                    townCnt++;
                }
            }
        }

        // 단지에 속하는 집의 수 오름차순 정렬
        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        sb.append(townCnt).append('\n');
        for (int x : result)
            sb.append(x).append('\n');
        System.out.print(sb);
    }

    static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if (x >= 0 && y >= 0 && x < N && y < N) {
                    if (map[x][y] == 1 && !visited[x][y]) {
                        queue.add(new int[]{x, y});
                        visited[x][y] = true;
                        houseCnt++;
                    }
                }
            }
        }
    }
}
