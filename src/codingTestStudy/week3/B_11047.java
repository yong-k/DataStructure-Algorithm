package codingTestStudy.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 동전 종류
        int K = Integer.parseInt(st.nextToken());   // 만들려는 돈의 합
        int[] money = new int[N];
        int count = 0;

        for (int i = 0; i < N; i++)
            money[i] = Integer.parseInt(br.readLine());

        for (int i = N - 1; i >= 0; i--) {
            if (K == 0)
                break;
            if (K < money[i])
                continue;
            count += K / money[i];
            K %= money[i];
        }
        System.out.println(count);
    }
}
