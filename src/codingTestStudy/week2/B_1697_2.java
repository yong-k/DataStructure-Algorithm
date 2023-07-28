package codingTestStudy.week2;
// https://bcp0109.tistory.com/61

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1697_2 {
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        check = new int[100001];

        if (N >= K)
            System.out.println(N - K);
        else
            System.out.println(BFS(N, K));
    }

    static int BFS(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        check[N] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0)
                    next = now - 1;
                else if (i == 1)
                    next = now + 1;
                else
                    next = now * 2;

                if (next == K)
                    return check[now];

                if (0 <= next && next <= 100000) {
                    if (check[next] == 0) {
                        queue.add(next);
                        check[next] = check[now] + 1;
                    }
                }
            }
        }

        return 0;
    }
}
