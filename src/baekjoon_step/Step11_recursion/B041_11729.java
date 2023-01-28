package baekjoon_step.Step11_recursion;

import java.io.*;
public class B041_11729 {
    static StringBuilder sb;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        hanoi(N, 1, 3);
        System.out.println(count);
        System.out.print(sb.toString());
    }

    static String hanoi(int N, int x, int y) {
        if (N > 1) {
            hanoi(N - 1, x, 6 - x - y);
        }
        sb.append(x + " " + y).append('\n');
        count++;
        if (N > 1) {
            hanoi(N - 1,6 - x - y, y);
        }
        return sb.toString();
    }
}
