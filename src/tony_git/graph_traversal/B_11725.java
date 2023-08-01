package tony_git.graph_traversal;
// https://jamesblog95.tistory.com/entry/11752%EB%B2%88-%ED%8A%B8%EB%A6%AC%EC%9D%98-%EB%B6%80%EB%AA%A8-%EC%B0%BE%EA%B8%B0
import java.io.*;
import java.util.*;
public class B_11725 {
    static int N;
    static ArrayList<Integer>[] A;
    static int[] parent;    // 부모 노드 정보 담을 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new ArrayList[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        BFS(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++)
            sb.append(parent[i]).append('\n');
        System.out.print(sb);
    }

    static void BFS(int node) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int child : A[now]) {
                if (!visited[child]) {
                    queue.add(child);
                    visited[child] = true;
                    parent[child] = now;
                }
            }
        }
    }
}
