package baekjoon_step.Step27_graph;

import java.io.*;
import java.util.*;
public class B02_24480 {
    static ArrayList<Integer>[] A;
    static int[] visited;
    static int count = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        visited = new int[N + 1];
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
            Collections.sort(A[i], Collections.reverseOrder());

        DFS(R);

        for (int i = 1; i <= N; i++)
            System.out.println(visited[i]);
    }

    static void DFS(int node) {
        visited[node] = count++;
        for (int i : A[node])
            if (visited[i] == 0)
                DFS(i);
    }
}
