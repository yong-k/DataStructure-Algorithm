package tony_git.graph_traversal;

import java.util.*;
public class B_1325_BFS {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        A = new ArrayList[N + 1];
        result = new int[N + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            BFS(i);
        }

        int max = 0;
        for (int i = 1; i <= N; i++)
            max = Math.max(max, result[i]);
        for (int i = 1; i <= N; i++) {
            if (max == result[i])
                sb.append(i).append(' ');
        }
        System.out.println(sb);
    }

    static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i : A[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    result[i]++;
                    queue.add(i);
                }
            }
        }
    }
}
