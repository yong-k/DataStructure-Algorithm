package doit_codingTest;

import java.util.*;

public class C026_1260 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();
        A = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
            A[e].add(s);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }

        visited = new boolean[N + 1];
        DFS(V);

        System.out.println();

        visited = new boolean[N + 1];
        BFS(V);
    }

    static void DFS(int n) {
        System.out.print(n + " ");
        visited[n] = true;
        for (int x : A[n]) {
            if (!visited[x])
                DFS(x);
        }
    }

    static void BFS(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");

            for (int x : A[now]) {
                if (!visited[x]) {
                    visited[x] = true;
                    queue.add(x);
                }
            }
        }
    }
}
