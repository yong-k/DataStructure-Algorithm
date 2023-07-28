package codingTestStudy.week2;

// https://st-lab.tistory.com/118

import java.io.*;
public class B_9663 {
    static int[] arr;
    static int N;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        count = 0;

        nQueen(0);
        System.out.println(count);
    }

    static void nQueen(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (isPossible(depth))
                nQueen(depth + 1);
        }
    }

    static boolean isPossible(int col) {
        for (int i = 0; i < col; i++) {
            // 같은 행에 존재하는지
            if (arr[col] == arr[i])
                return false;

            // 대각선에 존재하는지 (열의 차 == 행의 차)
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i]))
                return false;
        }
        return true;
    }
}
