package baekjoon_step.Step27_graph;

import java.io.*;
import java.util.*;
public class B05_2606 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        DFS(1);
        System.out.println(count - 1);
    }

    static void DFS(int node) {
        count++;
        visited[node] = true;
        for (int i : A[node])
            if (!visited[i])
                DFS(i);
    }
}
