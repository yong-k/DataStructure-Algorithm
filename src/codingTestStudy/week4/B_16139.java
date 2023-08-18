package codingTestStudy.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int q = Integer.parseInt(br.readLine());

        // 알파벳 별로 누적합 모두 구하기
        int[][] prefixSum = new int[26][S.length() + 1];
        for (int i = 0; i < S.length(); i++) {
            prefixSum[S.charAt(i) - 'a'][i + 1]++;
            for (int j = 0; j < 26; j++)
                prefixSum[j][i + 1] += prefixSum[j][i];
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < q; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char key = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(prefixSum[key - 'a'][end + 1] - prefixSum[key - 'a'][start]).append('\n');
        }
        System.out.print(sb);
    }
}
