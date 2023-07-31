package tony_git.brute_force;

import java.io.*;
import java.util.*;
public class B_22864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());   // 1시간 일했을 때, 쌓인 피로도
        int B = Integer.parseInt(st.nextToken());   // 1시간 일했을 때, 일 처리량
        int C = Integer.parseInt(st.nextToken());   // 1시간 쉬었을 때, 줄어들 피로도
        int M = Integer.parseInt(st.nextToken());   // 최대 피로도 (넘으면 번아웃)
        int tired = 0;
        int workAmount = 0;

        for (int i = 0; i < 24; i++) {
            if (tired + A > M)
                tired = tired - C < 0 ? 0 : tired - C;
            else {
                tired += A;
                workAmount += B;
            }
        }
        System.out.println(workAmount);
    }
}
