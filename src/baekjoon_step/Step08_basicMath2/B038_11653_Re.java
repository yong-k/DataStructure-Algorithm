package baekjoon_step.Step08_basicMath2;

import java.io.*;

public class B038_11653_Re {
    static boolean[] prime = new boolean[10000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        /*
        int num = 2;
        while (N > 1) {
            if (N % num == 0) {
                N /= num;
                bw.write(num + "\n");
            }
            else
                num++;
        }
        */

        for (int i = 2; i * i <= N; i++) {
            while (N % i == 0) {
                bw.write(i + "\n");
                N /= i;
            }
        }

        if (N != 1)
            bw.write(N + "\n");     // "\n" 안붙이면 이상한 문자로 나옴옴

       bw.flush();
        bw.close();
    }
}
