package baekjoon_step.Step27_graph;

import java.io.*;
import java.util.*;
public class B06_1260 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        for (int i = 1; i <= N; i++)
            Collections.sort(A[i]);

        visited = new boolean[N + 1];
        DFS(V);
        System.out.println();
        visited = new boolean[N + 1];
        BFS(V);
        System.out.println();
    }

    static void DFS(int node) {
        System.out.print(node + " ");
        visited[node] = true;
        for (int i : A[node])
            if (!visited[i])
                DFS(i);
    }

    static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for (int i : A[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
