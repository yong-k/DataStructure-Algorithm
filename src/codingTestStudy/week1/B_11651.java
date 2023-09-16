package codingTestStudy.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class B_11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // y 좌표 오름차순 정렬
        // y 좌표 같다면, x좌표 오름차순 정렬
        Arrays.sort(arr, (int[] o1, int[] o2) -> {
            if (o1[1] == o2[1])
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        StringBuilder sb = new StringBuilder();
        for (int[] xy : arr)
            sb.append(xy[0] + " " + xy[1] + "\n");
        System.out.print(sb);
    }
}
