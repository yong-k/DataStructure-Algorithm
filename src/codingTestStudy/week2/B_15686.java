package codingTestStudy.week2;

import java.io.*;
import java.util.*;
public class B_15686 {
    static int N, M;
    static int[][] map;
    static ArrayList<Point> house;
    static ArrayList<Point> chicken;
    static int answer;
    static boolean[] open;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        // 집과 치킨집 좌표 넣음
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    house.add(new Point(i, j));
                else if (map[i][j] == 2)
                    chicken.add(new Point(i, j));
            }
        }
        answer = Integer.MAX_VALUE;
        open = new boolean[chicken.size()];

        DFS(0, 0);
        System.out.println(answer);
    }

    static void DFS(int start, int count) {
         if (count == M) {
             int result = 0;

             for (int i = 0; i < house.size(); i++) {
                 int temp = Integer.MAX_VALUE;

                 // 어떤 집과 치킨집 중 open한 치킨집의 모든 거리 비교
                 // 그 중 최소 거리 구함
                 for (int j = 0; j < chicken.size(); j++) {
                     if (open[j]) {
                         int distance = Math.abs(house.get(i).x - chicken.get(j).x)
                                 + Math.abs(house.get(i).y - chicken.get(j).y);
                         temp = Math.min(temp, distance);
                     }
                 }
                 result += temp;
             }
             answer = Math.min(answer, result);
             return;
         }

         // 백트래킹
        for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
            DFS(i + 1, count + 1);
            open[i] = false;
        }
    }

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
