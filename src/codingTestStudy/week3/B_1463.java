package codingTestStudy.week3;

// https://st-lab.tistory.com/133
// 코테책 p491
import java.io.*;
public class B_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(dp(N));
    }

    static int dp(int n) {
        int[] arr = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + 1;    // 1을 빼는 연산
            if (i % 2 == 0)
                arr[i] = Math.min(arr[i], arr[i / 2] + 1);
            if (i % 3 == 0)
                arr[i] = Math.min(arr[i], arr[i / 3] + 1);
        }
        return arr[n];
    }
}
