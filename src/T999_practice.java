
import java.io.*;
import java.util.*;
public class T999_practice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int num = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());   // L일만 사용가능
            int P = Integer.parseInt(st.nextToken());   // 연속하는 P일 중
            int V = Integer.parseInt(st.nextToken());   // V일 휴가

            if (L == 0 && P == 0 && V == 0) break;

            int answer = 0;
            answer += (V / P * L) + Math.min(V % P, L);

            sb.append("Case " + num++ + ": " + answer).append('\n');
        }
        System.out.print(sb);
    }
}