package inflearn_algorithm.ch01_String;

import java.io.*;
public class C12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            count++;
            if (str.charAt(i) == '#')
                sb.append(1);
            else if (str.charAt(i) == '*')
                sb.append(0);

            if (count == 7) {
                int number = 0;
                for (int j = 0; j < 7; j++)
                    number += (sb.charAt(j) - '0') * (int)(Math.pow(2, --count));
                result.append((char)number);
                sb.setLength(0);
            }
        }
        System.out.println(result);
    }
}
