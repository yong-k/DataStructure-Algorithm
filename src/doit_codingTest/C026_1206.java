package doit_codingTest;

import java.util.*;
import java.io.*;

public class C026_1206 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());   // 노드 개수
        int edge = Integer.parseInt(st.nextToken());   // 에지 개수
        int start = Integer.parseInt(st.nextToken());   // 시작점

        A = new ArrayList[node + 1];
        visited = new boolean[node + 1];
        for (int i = 1; i <= node; i++)
            A[i] = new ArrayList<Integer>();
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        // 정렬 → 번호가 작은 것 부터 돌아야 하니까
        for (int i = 1; i <= node; i++)
            Collections.sort(A[i]);

        DFS(start);
        System.out.println();
        visited = new boolean[node + 1];    // 방문배열 초기화
        BFS(start);
        System.out.println();
    }

    static void DFS(int node) {
        System.out.print(node + " ");
        visited[node] = true;
        for (int i : A[node])
            if (!visited[i])
                DFS(i);
    }

    static void BFS(int node) {
        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.add(node);
        visited[node] = true;

        while (!myQueue.isEmpty()) {
            int now = myQueue.poll();
            System.out.print(now + " ");
            for (int i : A[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    myQueue.add(i);
                }
            }
        }
    }
}
