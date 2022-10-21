package inflearn_algorithm.ch01_String;

import java.io.*;
public class C02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if (now >= 65 && now <= 90)
                result.append(Character.toLowerCase(now));
            else
                result.append(Character.toUpperCase(now));
        }
        System.out.println(result);
    }
}
