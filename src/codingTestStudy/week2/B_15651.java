package codingTestStudy.week2;

import java.util.*;
import java.io.*;
public class B_15651 {
    static int N, M;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        sb = new StringBuilder();

        DFS(0);
        System.out.println(sb);
    }

    static void DFS(int depth) {
        if (depth == M) {
            for (int i : arr)
                sb.append(i).append(' ');
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i + 1;
            DFS(depth + 1);
        }
    }
}
