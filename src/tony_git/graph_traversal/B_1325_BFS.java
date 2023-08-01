package tony_git.graph_traversal;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1325_BFS {
    static int N, M;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        result = new int[N + 1];

        for (int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            BFS(i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++)
            max = Math.max(max, result[i]);
        for (int i = 1; i <= N; i++) {
            if (max == result[i])
                bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }

    static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i : A[now]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    result[i]++;
                }
            }
        }
    }
}
