package baekjoon_step.Step04_array;
import java.io.*;
import java.util.*;
public class B_2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean[][] arr = new boolean[100][100];
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            for (int j = X; j < X + 10; j++)
                for (int k = Y; k < Y + 10; k++)
                    arr[j][k] = true;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j])
                    count++;
            }
        }
        System.out.println(count);
    }
}
