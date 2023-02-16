
import java.io.*;
import java.util.*;

public class T999_practice {

    static int[][] A;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++)
                A[i][j] = Integer.parseInt(line.substring(j, j + 1));
        }

        int danjiNum = 0;

    }
}

