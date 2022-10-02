package baekjoon;

import java.io.*;
import java.util.*;
public class B016_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0, max = 0, score = 0;
        for (int i = 0; i < num; i++) {
            score = Integer.parseInt(st.nextToken());
            if (max < score) max = score;
            sum += score;
        }
        System.out.println((double)sum / max * 100 / num);
    }
}
