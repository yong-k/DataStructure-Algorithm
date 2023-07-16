package baekjoon_step.Step04_array;

import java.io.*;
import java.util.*;
public class B016_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            sum += scores[i];
            if (max < scores[i])
                max = scores[i];
        }

        System.out.println(sum * 100.0 / max / N);
    }
}
