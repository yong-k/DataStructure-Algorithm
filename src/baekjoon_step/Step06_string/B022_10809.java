package baekjoon_step.Step06_string;

import java.io.*;
public class B022_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++)
            sb.append(str.indexOf(((char)(i + 97))) + " ");
        System.out.println(sb);
    }
}
