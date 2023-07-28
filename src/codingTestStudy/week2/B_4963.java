package codingTestStudy.week2;

// https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-4963%EB%B2%88-%EC%84%AC%EC%9D%98-%EA%B0%9C%EC%88%98-%EC%9E%90%EB%B0%94Java

import java.util.*;
public class B_4963 {
    static int w, h;
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;

        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();
            if (w == 0 && h == 0)
                return;

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++)
                    map[i][j] = sc.nextInt();
            }

            count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        DFS(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void DFS(int i, int j) {
        visited[i][j] = true;
        for (int k = 0; k < 8; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x >= 0 && y >= 0 && x < h && y < w) {
                if (map[x][y] == 1 && !visited[x][y])
                    DFS(x, y);
            }
        }
    }
}
