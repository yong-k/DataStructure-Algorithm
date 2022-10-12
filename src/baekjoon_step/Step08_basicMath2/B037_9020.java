package baekjoon_step.Step08_basicMath2;

import java.io.*;
public class B037_9020 {
    static boolean[] prime = new boolean[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int loop = Integer.parseInt(br.readLine());
        get_prime();
        for (int i = 0; i < loop; i++) {
            int n = Integer.parseInt(br.readLine());
            int start = n / 2;
            int end = n / 2;
            while (true) {
                if (!prime[start] && !prime[end]) {
                    bw.write(start + " " + end + "\n");
                    break;
                }
                start--;
                end++;
            }
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
