package baekjoon_step.Step04_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max = 0;
        int max_x = 0;
        int max_y = 0;
        int nowNum = 0;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                nowNum = Integer.parseInt(st.nextToken());
                if (max < nowNum) {
                    max = nowNum;
                    max_x = i;
                    max_y = j;
                }
            }
        }
        System.out.println(max);
        System.out.println((max_x + 1) + " " + (max_y + 1));
    }
}
