package codingTestStudy.week1;

import java.io.*;
import java.util.*;
public class B_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            set.add(Integer.parseInt(st.nextToken()));

        int M = Integer.parseInt(br.readLine());
        int[] cards = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            cards[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i : cards)
            sb.append(set.contains(i) ? '1' : '0').append(' ');
        System.out.println(sb);
    }
}
