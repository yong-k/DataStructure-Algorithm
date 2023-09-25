package codingTestStudy.week2;

import java.util.*;
import java.io.*;
public class B_2606_BFS {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        BFS(1);
        System.out.println(count);
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
                    count++;
                }
            }
        }
    }
}
