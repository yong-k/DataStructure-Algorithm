package tony_git.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] timeTable = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            timeTable[i][0] = Integer.parseInt(st.nextToken());
            timeTable[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(timeTable, (int[] t1, int[] t2) -> {
            if (t1[1] == t2[1])
                return t1[0] - t2[0];
            return t1[1] - t2[1];
        });

        int count = 0;
        int end = -1;
        for (int i = 0; i < N; i++) {
            if (timeTable[i][0] >= end) {
                end = timeTable[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
