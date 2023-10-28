package codingTestStudy.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 도시 개수
        long[] distance = new long[N - 1];
        long[] oilPrice = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < distance.length; i++)
            distance[i] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < oilPrice.length; i++)
            oilPrice[i] = Long.parseLong(st.nextToken());

        long answer = 0;
        long minOilPrice = oilPrice[0];
        for (int i = 0; i < N - 1; i++) {
            minOilPrice = Math.min(minOilPrice, oilPrice[i]);
            answer += minOilPrice * distance[i];
        }
        System.out.println(answer);
    }
}
