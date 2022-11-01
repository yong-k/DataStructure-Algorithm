package baekjoon_step.Step26_graph;

import java.io.*;
import java.util.*;
public class B05_2606 {
    static ArrayList<Integer> A[];
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        A = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++)
            A[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        DFS(1);
        int count = 0;
        for (int i = 2; i <= n; i++)
            if (visited[i])
                count++;
        System.out.println(count);
    }

    static void DFS(int n) {
        if (visited[n])
            return;
        visited[n] = true;
        for (int x : A[n])
            if (!visited[x])
                DFS(x);
    }
}
