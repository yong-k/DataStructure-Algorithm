
import java.io.*;
import java.util.*;
public class T999_practice<T> {
    static int n;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] A;
    static boolean[][] visited;
    static ArrayList<Integer> apart = new ArrayList<>();
    static int apartNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                A[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1 && !visited[i][j]) {
                    apartNum = 0;
                    DFS(i, j);
                    apart.add(apartNum);
                }
            }
        }

        System.out.println(apart.size());
        for (int x : apart)
            System.out.println(x);
    }

    static void DFS(int i, int j) {
        visited[i][j] = true;
        apartNum++;

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && y >= 0 && x < n && y < n) {
                if (A[x][y] == 1 && !visited[x][y]) {
                    DFS(x, y);
                }
            }
        }
    }
}

