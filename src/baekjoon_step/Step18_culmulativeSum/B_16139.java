package baekjoon_step.Step18_culmulativeSum;

import java.io.*;
import java.util.*;

public class B_16139 {
    public static void main(String[] args) throws IOException {
        // 50점
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String S = br.readLine();
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int count = 0;
            for (int j = s; j <= e; j++)
                if (S.charAt(j) == c) count++;
            sb.append(count + "\n");
        }
        System.out.println(sb);
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] sum = new int[s.length() + 1][26];  // 누적합 배열
        sum[1][s.charAt(0) - 'a']++;            // 처음 값 횟수 증가
        // 나머지 문자 탐색
        for (int i = 2; i < s.length(); i++) {
            int idx = s.charAt(i - 1) - 'a';
            for (int j = 0; j < 26; j++) {
                int before = sum[i - 1][j];
                sum[i][j] = (j == idx) ? before + 1 : before;
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int find = st.nextToken().charAt(0) - 'a';
            int start = Integer.parseInt(st.nextToken()) + 1;
            int end = Integer.parseInt(st.nextToken()) + 1;
            bw.append((sum[end][find] - sum[start - 1][find]) + "\n");
        }
        bw.close();
        br.close();
    }
}
