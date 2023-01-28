package baekjoon_step.Step10_sorting;

import java.io.*;
import java.util.*;

public class B_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] originArr = new int[N];
        int[] sortedArr = new int[N];
        HashMap<Integer, Integer> rankedMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            originArr[i] = sortedArr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(sortedArr);

        int rank = 0;
        for (int x : sortedArr)
            if (!rankedMap.containsKey(x))
                rankedMap.put(x, rank++);

        StringBuilder sb = new StringBuilder();
        for (int key : originArr) {
            sb.append(rankedMap.get(key)).append(' ');
        }
        System.out.println(sb.toString());
    }
}
