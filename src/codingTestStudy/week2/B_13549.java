package codingTestStudy.week2;

import java.io.*;
import java.util.*;
public class B_13549 {
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        check = new int[100001];
        // **순간이동하면 0초이므로, -1로 초기화 작업
        for (int i = 0; i < check.length; i++)
            check[i] = -1;

        if (N == K) {
            System.out.println(0);
            return;
        }
        BFS(N, K);
        System.out.println(check[K]);
    }

    static void BFS(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        check[N] = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            // 순간이동은 0초니까, 제일 먼저 수행하기!
            if (2 * x < check.length && check[2 * x] == -1) {
                queue.add(2 * x);
                check[2 * x] = check[x];
            }
            if (x - 1 >= 0 && check[x - 1] == -1) {
                queue.add(x - 1);
                check[x - 1] = check[x] + 1;
            }
            if (x + 1 < check.length && check[x + 1] == -1) {
                queue.add(x + 1);
                check[x + 1] = check[x] + 1;
            }
        }
    }
}
