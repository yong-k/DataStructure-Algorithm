package baekjoon_step.Step27_graph;

import java.io.*;
import java.util.*;

public class B_2667_DFS {
    // https://incomeplus.tistory.com/408
    // https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-2667%EB%B2%88-%EB%8B%A8%EC%A7%80%EB%B2%88%ED%98%B8%EB%B6%99%EC%9D%B4%EA%B8%B0-%EC%9E%90%EB%B0%94Java

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int count;                   // 집의 수 카운트
    static ArrayList<Integer> result;   // 단지 별 집의 수 저장
    static int[] dx = {0, 0, -1, 1};    // 상 하 좌 우
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        count = 0;
        result = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 1;  // 단지의 첫 번째 집이니까 1로 초기화
                    DFS(i, j);
                    result.add(count);
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for (int x : result)
            System.out.println(x);
    }

    static void DFS(int i, int j) {
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && y >= 0 && x < N && y < N) {
                if (map[x][y] == 1 && !visited[x][y]) {
                    DFS(x, y);
                    count++;
                }
            }
        }
    }
}
