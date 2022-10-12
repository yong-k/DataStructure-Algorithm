package baekjoon_step.Step08_basicMath2;

import java.io.*;
public class B038_11653 {
    static boolean[] prime = new boolean[10000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        get_prime();
        int num = 1;
        while (N > 1) {
            if (prime[num]) {
                num++;
                continue;
            }
            if (N % num != 0) {
                num++;
                continue;
            }
            N /= num;
            bw.write(num + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void get_prime() {
        prime[0] = prime[1] = true;
        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i])
                continue;
            for (int j = i + i; j < prime.length; j += i)
                prime[j] = true;
        }
    }
}
