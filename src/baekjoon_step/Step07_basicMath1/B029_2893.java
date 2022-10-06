package baekjoon_step.Step07_basicMath1;

import java.io.*;
public class B029_2893 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int kg = Integer.parseInt(br.readLine());
        int threeKg = 0;
        int fiveKg = kg / 5;
        while (fiveKg >= 0) {
            if ( (kg - (5 * fiveKg)) % 3 == 0) {
                threeKg = (kg - (5 * fiveKg)) / 3;
                break;
            }
            else
                fiveKg -= 1;
        }

        if (fiveKg < 0)
            System.out.println(-1);
        else
            System.out.println(fiveKg + threeKg);
    }
}
