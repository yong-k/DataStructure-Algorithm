package codingTestStudy.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 물이 새는 곳의 개수
        int L = Integer.parseInt(st.nextToken());   // 테이프 길이
        int[] pipe = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            pipe[i] = Integer.parseInt(st.nextToken());

        // 파이프 정렬
        Arrays.sort(pipe);

        // 현재까지 붙인 테이프의 마지막 위치
        double endPoint = pipe[0] - 0.5 + L;
        int tapeCnt = 1;
        for (int i = 1; i < N; i++) {
            // 다음 파이프가 현재까지 붙인 테이프의 범위를 넘어가면, 새로운 테이프 사용
            if (pipe[i] > endPoint) {
                tapeCnt++;
                endPoint = pipe[i] - 0.5 + L;
            }
        }
        System.out.println(tapeCnt);
    }
}
