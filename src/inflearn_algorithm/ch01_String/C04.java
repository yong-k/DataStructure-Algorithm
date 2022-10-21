package inflearn_algorithm.ch01_String;

import java.io.*;
public class C04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = str.length() - 1; j >= 0; j--)
                sb.append(str.charAt(j));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
