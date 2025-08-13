package doit_codingTest;

import java.util.ArrayList;
import java.util.Scanner;

public class C023_11724 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
            A[e].add(s);
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                DFS(i);
                count++;
            }
        }
        System.out.println(count);
    }

    static void DFS(int n) {
        visited[n] = true;
        for (int x : A[n]) {
            if (!visited[x])
                DFS(x);
        }
    }
}
