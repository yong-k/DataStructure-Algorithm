package doit_codingTest;

import java.util.ArrayList;
import java.util.Scanner;

public class C025_13023 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        A = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
            A[e].add(s);
        }

        for (int i = 0; i < N; i++) {
            DFS(i, 1);

            if (flag)
                break;
        }

        if (flag)
            System.out.println(1);
        else
            System.out.println(0);
    }

    static void DFS(int n, int depth) {
        if (depth == 5 || flag) {
            flag = true;
            return;
        }
        visited[n] = true;
        for (int x : A[n]) {
            if (!visited[x])
                DFS(x, depth + 1);
        }

        visited[n] = false;
    }
}
