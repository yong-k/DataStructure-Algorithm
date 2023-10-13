package tony_git.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://smartpro.tistory.com/18
public class B_1697 {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N));
    }

    static int bfs(int node) {
        int[] visited = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = 1;
        int n = 0;

        while (!queue.isEmpty()) {
            n = queue.poll();
            if (n == K) {
                return visited[n] - 1;
            }
            if (n - 1 >= 0 && visited[n - 1] == 0) {
                visited[n - 1] = visited[n] + 1;
                queue.add(n - 1);
            }
            if (n + 1 < 100001 && visited[n + 1] == 0) {
                visited[n + 1] = visited[n] + 1;
                queue.add(n + 1);
            }
            if (n * 2 < 100001 && visited[n * 2] == 0) {
                visited[n * 2] = visited[n] + 1;
                queue.add(n * 2);
            }
        }
        return -1;
    }
}
