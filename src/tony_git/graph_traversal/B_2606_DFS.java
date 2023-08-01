package tony_git.graph_traversal;

import java.io.*;
import java.util.*;
public class B_2606_DFS {
    static int computer, network;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computer = Integer.parseInt(br.readLine());
        network = Integer.parseInt(br.readLine());
        A = new ArrayList[computer + 1];
        visited = new boolean[computer + 1];

        for (int i = 1; i <= computer; i++)
            A[i] = new ArrayList<>();
        for (int i = 0; i < network; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
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
