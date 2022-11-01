package inflearn_algorithm.ch02_Array;

// 3중 반복문 없애고 다시 풀어야 함
import java.io.*;
import java.util.*;
public class C11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        boolean[][] result = new boolean[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        // 1번학생~5번학생
        for (int i = 0; i < n; i++) {
            // 1학년~5학년
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i == k) continue;
                    if (arr[i][j] == arr[k][j])
                        result[i][k] = true;
                }
            }
        }

        int count = 0;
        int maxCount = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = 0; j < n; j++)
                if (result[i][j])
                    count++;
            if (count > maxCount) {
                maxCount = count;
                maxIdx = i;
            }
        }
        System.out.println(maxIdx + 1);
    }
}
