package tony_git.graph_traversal;

import java.io.*;
import java.util.*;
public class B_16918 {
    static int R, C;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                char now = s.charAt(j);
                if (now == '.')
                    map[i][j] = -1;
                else
                    map[i][j] = 2;      // 처음 1초 동안은 아무것도 안하니까, 2초로 넣음
            }
        }

        callBomberman(N - 1);       // 처음 1초 동안은 아무것도 안하니까

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1)
                    sb.append('.');
                else
                    sb.append('O');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void callBomberman(int time) {
        // *폭탄 설정 → 3초
        // *1초되면   → 터짐
        int count = 0;  // 번갈아서 진행(홀수→ 폭탄설치, 짝수→터뜨림)

        while (time != 0) {
            // 1바퀴 = -1초
            // 배열 돌면서, -1 아닌거 -> 1초씩 줄임
            //                이면  -> 폭탄설치 (3으로)
            // 1초된거 터뜨림, 본인, 상하좌우 모두 -1로 바꿈
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (count % 2 == 0) {
                        if (map[i][j] == -1) {  // 폭탄 없다면, 설치
                            map[i][j] = 3;
                        }
                        else                    // 폭탄 있으면, 시간-1
                            map[i][j]--;
                    } else {
                        if (map[i][j] == 1) {  // 1초면 터뜨리기
                            map[i][j] = -1;

                            for (int k = 0; k < 4; k++) {
                                int x = i + dx[k];
                                int y = j + dy[k];
                                if (x >= 0 && y >= 0 && x < R && y < C) {
                                    // 돌면서 현재상태 1인거는 지금 건들면 안됨(지금 터뜨려버리면, 걔 주변 폭탄 못 터뜨림)
                                    if (map[x][y] != 1)
                                        map[x][y] = -1;
                                }
                            }
                        } else if (map[i][j] > 1)   // 1초 이상이면, 시간-1
                            map[i][j]--;
                    }
                }
            }
            time--;
            count++;
        }
    }
}
