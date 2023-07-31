package tony_git.brute_force;

import java.io.*;
import java.util.*;
public class B_18511 {
    static int N, K;
    static int[] arrK;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // N보다 작거나 같은 자연수 중 ~~
        K = Integer.parseInt(st.nextToken());   // 집합 K의 원소 개수
        arrK = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++)
            arrK[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arrK);
        DFS(0);
        System.out.println(answer);
    }

    static void DFS(int now) {
        if (now > N)
            return;
        if (answer < now)
            answer = now;

        for (int i = arrK.length - 1; i >= 0; i--)
            DFS(now * 10 + arrK[i]);
    }
}
