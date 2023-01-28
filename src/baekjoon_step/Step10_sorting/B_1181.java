package baekjoon_step.Step10_sorting;

import java.io.*;
import java.util.*;

public class B_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++)
            arr[i] = br.readLine();

        Arrays.sort(arr, (o1, o2) -> {

            // 사전 순 정렬 → compareTo()
            if (o1.length() == o2.length())
                return o1.compareTo(o2);

            return o1.length() - o2.length();
        });

        System.out.println(arr[0]);
        for (int i = 1; i < N; i++)
            if (!arr[i].equals(arr[i - 1]))
                System.out.println(arr[i]);
    }
}
