package codingTestStudy.week2;
// https://fbtmdwhd33.tistory.com/34

import java.util.*;
import java.io.*;
public class B_1697_1 {
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        check = new int[100001];

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
        check[N] = 0;   // 수빈이 현위치 0

        while (!queue.isEmpty()) {
            int x = queue.poll();

            // 3가지 경우 범위 확인
            // 1) x - 1
            if (x - 1 >= 0 && check[x - 1] == 0) {
                queue.add(x - 1);
                check[x - 1] = check[x] + 1;
            }

            // 2) x + 1
            if (x + 1 < check.length && check[x + 1] == 0) {
                queue.add(x + 1);
                check[x + 1] = check[x] + 1;
            }

            // 3) 2 * x
            if (2 * x < check.length && check[2 * x] == 0) {
                queue.add(2 * x);
                check[2 * x] = check[x] + 1;
            }
        }
    }
}
