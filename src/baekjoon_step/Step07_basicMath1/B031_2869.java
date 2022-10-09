package baekjoon_step.Step07_basicMath1;

import java.io.*;
import java.util.*;
public class B031_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int result = 0;
        int day = 0;

        // 시간초과 나옴
        while (true) {
            day++;
            result += up;
            if (result >= height)
                break;
            result -= down;
        }
        System.out.println(day);
    }
}
