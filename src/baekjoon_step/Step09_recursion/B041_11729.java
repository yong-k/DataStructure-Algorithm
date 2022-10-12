package baekjoon_step.Step09_recursion;

import java.io.*;
public class B041_11729 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb.append((int)(Math.pow(2, N) - 1)).append("\n");
        hanoi(N, 1, 2, 3);
        System.out.println(sb);
    }

    // N: 원판 개수
    // start, mid, end: 출발지, 옮기기 위해 이동해야 하는 장소, 목적지
    static void hanoi(int N, int start, int mid, int end) {
        // 이동할 원반의 개수가 1개면,
        if (N == 1) {
            sb.append(start + " " + end + "\n");
            return;
        }
        // A → C로 이동해야 할 때,
        // Step1: N-1개를 A → B 로 이동
        hanoi(N - 1, start, end, mid);

        // Step2: 1개를 A → C 로 이동
        sb.append(start + " " + end + "\n");

        // Step3: N-1개를 B → C 로 이동
        hanoi(N - 1, mid, start, end);
    }
}
