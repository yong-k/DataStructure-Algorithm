package baekjoon_step.Step27_graph;

import java.io.*;
import java.util.*;
public class B06_1260 {
    static ArrayList<Integer> A[];
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());
        A = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            A[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        for (int i = 1; i <= n; i++)
            Collections.sort(A[i]);

        visited = new boolean[n + 1];
        DFS(startNode);
        System.out.println();
        visited = new boolean[n + 1];
        BFS(startNode);
    }

    static void DFS(int n) {
        if (visited[n])
            return;
        System.out.print(n + " ");
        visited[n] = true;
        for (int x : A[n])
            if (!visited[x])
                DFS(x);
    }

    static void BFS(int n) {
        if (visited[n])
            return;

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");
            for (int x : A[now]) {
                if (!visited[x]) {
                    q.add(x);
                    visited[x] = true;
                }
            }
        }
    }
}
