package baekjoon_step.Step12_bruteForce;

import java.io.*;
public class B046_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int num = 666;
        int count = 1;
        while (count < N) {
            num++;
            if (Integer.toString(num).contains("666"))
                count++;
        }
        System.out.println(num);
    }
}
