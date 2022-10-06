package baekjoon_step.Step06_string;

import java.io.*;
public class B021_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        /*
        String str = br.readLine();
        int sum = 0;
        for (int i = 0; i < str.length(); i++)
            sum += str.charAt(i) - '0';
        System.out.println(sum);
        */

        int sum = 0;
        for (byte b : br.readLine().getBytes())
            sum += b - '0';
        System.out.println(sum);
    }
}
