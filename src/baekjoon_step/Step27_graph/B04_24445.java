package baekjoon_step.Step27_graph;

import java.io.*;
import java.util.*;
public class B04_24445 {
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

        BFS(R);

        for (int i = 1; i <= N; i++)
            System.out.println(visited[i]);
    }

    static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = count++;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i : A[now]) {
                if (visited[i] == 0) {
                    visited[i] = count++;
                    queue.add(i);
                }
            }
        }
    }
}
