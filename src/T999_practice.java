
import javax.swing.*;
import java.io.*;
import java.util.*;
public class T999_practice {
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
        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int start, int count) {
        if (count == M) {
            int result = 0;
            for (int i = 0; i < house.size(); i++) {
                int temp = Integer.MAX_VALUE;
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

        for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
            dfs(i + 1, count + 1);
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