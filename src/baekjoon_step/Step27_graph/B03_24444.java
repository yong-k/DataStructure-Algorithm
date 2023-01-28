package baekjoon_step.Step27_graph;

import java.io.*;
import java.util.*;
public class B03_24444 {
    static ArrayList<Integer> A[];
    static int[] visited;
    static int count = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());
        A = new ArrayList[n + 1];
        visited = new int[n + 1];
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
        BFS(startNode);

        for (int i = 1; i <= n; i++)
            System.out.println(visited[i]);
    }

    static void BFS(int n) {
        if (visited[n] != 0)
            return;

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = count++;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int x : A[now]) {
                if (visited[x] == 0) {
                    q.add(x);
                    visited[x] = count++;
                }
            }
        }
    }
}
