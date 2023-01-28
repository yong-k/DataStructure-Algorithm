package baekjoon_step.Step10_sorting;

import java.io.*;
import java.util.*;

public class B_11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            list.add(Integer.parseInt(st.nextToken()));
        Collections.sort(list);

        System.out.println(list.get(K - 1));
    }
}
