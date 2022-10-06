package baekjoon_step.Step06_string;

import java.io.*;
public class B027_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            String str = (br.readLine()).toLowerCase();
            boolean[] alphabet = new boolean[26];
            // char 초기화할 때 '' 는 사용불가. 일반적으로 ' ' (공백)으로 초기화함
            //char prev = '';
            char prev = ' ';
            int j = 0;
            for (j = 0; j < str.length(); j++) {
                if (prev == str.charAt(j))
                    continue;
                if (alphabet[str.charAt(j) - 97])
                    break;
                alphabet[str.charAt(j) - 97] = true;
                prev = str.charAt(j);
            }
            if (j == str.length())
                count++;
        }
        System.out.println(count);
    }
}
