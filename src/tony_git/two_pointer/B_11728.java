package tony_git.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arrAB = new int[N + M];
        st = new StringTokenizer(br.readLine());
        int i = 0;
        for (i = 0; i < N; i++)
            arrAB[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int j = i; j < arrAB.length; j++)
            arrAB[j] = Integer.parseInt(st.nextToken());

        Arrays.sort(arrAB);

        StringBuilder sb = new StringBuilder();
        for (int x : arrAB)
            sb.append(x).append(' ');
        System.out.println(sb);
    }
}
