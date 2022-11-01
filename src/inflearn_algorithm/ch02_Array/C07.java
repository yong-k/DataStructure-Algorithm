package inflearn_algorithm.ch02_Array;

import java.io.*;
import java.util.*;
public class C07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int score = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int answer = Integer.parseInt(st.nextToken());
            if (answer == 1)
                sum += score++;
            else
                score = 1;
        }
        System.out.println(sum);
    }
}
