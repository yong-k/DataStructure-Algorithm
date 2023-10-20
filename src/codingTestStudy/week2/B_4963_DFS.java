package codingTestStudy.week2;

// https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-4963%EB%B2%88-%EC%84%AC%EC%9D%98-%EA%B0%9C%EC%88%98-%EC%9E%90%EB%B0%94Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class B_4963_DFS {
    static int M, N;
    static int[][] map;
    static boolean[][] visited;
    // 8방향 확인해야 함
    /*          북[0,1]
        북서[-1,1]    북동[1,1]
    서[-1,0]               동[1,0]
        남서[-1,-1]   남동[1,-1]
                남[0,-1]
    */
    // 북에서 시계방향으로
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            if (M == 0 && N == 0) break;

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int i, int j) {
        visited[i][j] = true;
        for (int k = 0; k < 8; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x < 0 || y < 0 || x >= N || y >= M) continue;
            if (map[x][y] == 1 && !visited[x][y])
                dfs(x, y);
        }
    }
}