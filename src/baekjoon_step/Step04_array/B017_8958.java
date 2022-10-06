package baekjoon_step.Step04_array;

import java.io.*;
public class B017_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = "";
        int result = 0;
        int score = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            str = br.readLine();
            score = 0;
            result = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'O')
                    score++;
                else
                    score = 0;
                result += score;
            }
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }
}
