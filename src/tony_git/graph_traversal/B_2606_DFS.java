package tony_git.graph_traversal;

import java.util.*;
public class B_2606_DFS {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int computers = sc.nextInt();
        int networks = sc.nextInt();
        A = new ArrayList[computers + 1];
        visited = new boolean[computers + 1];

        for (int i = 1; i <= computers; i++)
            A[i] = new ArrayList<>();

        for (int i = 0; i < networks; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
            A[e].add(s);
        }

        DFS(1);
        System.out.println(count);
    }

    static void DFS(int node) {
        visited[node] = true;
        for (int i : A[node]) {
            if (!visited[i]) {
                DFS(i);
                count++;
            }
        }
    }
}
