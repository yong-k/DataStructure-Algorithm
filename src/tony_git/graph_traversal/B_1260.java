package tony_git.graph_traversal;

import java.util.*;
public class B_1260 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();
        A = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
            A[e].add(s);
        }

        // 방문할 수 있는 정점이 여러 개인 경우에는 번호 작은 것부터 방문
        for (int i = 1; i <= N; i++)
            Collections.sort(A[i]);

        visited = new boolean[N + 1];
        DFS(V);
        System.out.println();
        visited = new boolean[N + 1];
        BFS(V);
    }

    static void DFS(int node) {
        System.out.print(node + " ");
        visited[node] = true;
        for (int i : A[node]) {
            if (!visited[i])
                DFS(i);
        }
    }

    static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for (int i : A[now]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
