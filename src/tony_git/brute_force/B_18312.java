package tony_git.brute_force;

import java.io.*;
import java.util.*;
public class B_18312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String K = st.nextToken();
        long answer = 0;
        String temp = "";

        //** 0이 포함됐을 때 주의
        for (int i = 0; i <= N; i++) {
            if (i < 10) temp = "0" + i;
            else temp = "" + i;

            if (temp.contains(K)) {
                answer += 60*60;
                continue;
            }
            for (int j = 0; j < 60; j++) {
                if (j < 10) temp = "0" + j;
                else temp = "" + j;

                if (temp.contains(K)) {
                    answer += 60;
                    continue;
                }
                for (int m = 0; m < 60; m++) {
                    if (m < 10) temp = "0" + m;
                    else temp = "" + m;

                    if (temp.contains(K)) {
                        answer++;
                        continue;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
