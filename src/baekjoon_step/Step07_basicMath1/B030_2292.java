package baekjoon_step.Step07_basicMath1;
/*
Level
    1: 1        → 1개
    2: 2 ~ 7    → 6개
    3: 8 ~ 19   → 12개
    4: 20 ~ 37  → 18개
    5: 38 ~ 61  → 24개
    :
    :
*/
import java.io.*;
public class B030_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int n = 0;
        int sum = 1;
        while(true) {
            sum += 6 * n++;
            if (input <= sum)
                break;
        }
        System.out.println(n);
    }
}
