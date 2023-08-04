package codingTestStudy.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int camping = 0;
        int num = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());   // L일 동안 사용가능
            int P = Integer.parseInt(st.nextToken());   // 연속하는 P일 중
            int V = Integer.parseInt(st.nextToken());   // V일짜리 휴가 시작

            if (L == 0 && P == 0 && V == 0)
                break;

            /*
            * 20 / 8 = 2 → 2*5 = 10
            * 20 % 8 = 4 → 1)L보다 작은 경우 2)L보다 큰 경우
            * */
            camping = V / P * L;
            camping += Math.min(V % P, L);
            sb.append("Case " + num++ + ": " + camping + "\n");
        }
        System.out.print(sb);
    }
}
