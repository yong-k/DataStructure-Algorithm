package codingTestStudy.week2;

import java.util.*;
import java.io.*;
public class B_2589 {
    static int w, h;
    static char[][] map;
    static int[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new char[w][h];

        for (int i = 0; i < w; i++) {
            String s = br.readLine();
            for (int j = 0; j < h; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int max = 0;
        int distance = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (map[i][j] == 'L') {
                    visited = new int[w][h];
                    distance = BFS(i, j);
                    max = Math.max(max, distance - 1);
                }
            }
        }
        System.out.println(max);
    }

    static int BFS(int i, int j) {
        int distance = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = 1;
        //-- visited배열 -1 초기화 안한 대신 초깃값 1로 설정
        //   그 대신 main 함수에서 max랑 비교할 때 -1 해줘야함

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if (x >= 0 && y >= 0 && x < w && y < h) {
                    if (map[x][y] == 'L' && visited[x][y] == 0) {
                        queue.add(new int[]{x, y});
                        visited[x][y] = visited[now[0]][now[1]] + 1;
                        distance = visited[x][y];
                    }
                }
            }
        }
        return distance;
    }
}
