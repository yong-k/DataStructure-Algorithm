import java.util.*;
import java.io.*;
public class T999_practice {
    static int N, K;
    static int[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        check = new int[100001];
        for (int i = 0; i < check.length; i++)
            check[i] = -1;

        if (N == K) {
            System.out.println(0);
            return;
        } else {
            BFS(N, K);
            System.out.println(check[K]);
        }
    }

    static void BFS(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        check[N] = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (2 * x < check.length && check[2 * x] == -1) {
                queue.add(x * 2);
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

