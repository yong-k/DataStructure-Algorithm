package doit_codingTest;

import java.util.*;

public class C028_1167 {
    static ArrayList<Edge2>[] A;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        A = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 1; i <= V; i++) {
            int s = sc.nextInt();

            while (true) {
                int e = sc.nextInt();
                if (e == -1) break;
                int v = sc.nextInt();

                A[s].add(new Edge2(e, v));
            }
        }

        visited = new boolean[V + 1];
        distance = new int[V + 1];
        BFS(1);

        int max = 1;
        for (int i = 2; i <= V; i++) {
            if (distance[max] < distance[i])
                max = i;
        }

        visited = new boolean[V + 1];
        distance = new int[V + 1];
        BFS(max);

        Arrays.sort(distance);
        System.out.println(distance[V]);
    }

    static void BFS(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Edge2 e : A[now]) {
                int node = e.node;
                int value = e.value;
                if (!visited[node]) {
                    queue.add(node);
                    visited[node] = true;
                    distance[node] = distance[now] + value;
                }
            }
        }
    }
}

class Edge2 {
    int node;
    int value;

    public Edge2(int node, int value) {
        this.node = node;
        this.value = value;
    }
}