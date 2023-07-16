package codingTestStudy.week1;

import java.util.*;
import java.io.*;
public class B_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sortedArr = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            arr[i] = sortedArr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(sortedArr);

        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (!map.containsKey(sortedArr[i]))
                map.put(sortedArr[i], idx++);
        }

        for (int i : arr)
            sb.append(map.get(i)).append(' ');
        System.out.println(sb);
    }
}
