package inflearn_algorithm.ch01_String;

import java.io.*;
public class C11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        char prev = str.charAt(0);
        sb.append(prev);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == prev)
                count++;
            else {
                prev = str.charAt(i);
                if (count > 1)
                    sb.append(count);
                count = 1;
                sb.append(str.charAt(i));
            }
        }
        if (count > 1)
            sb.append(count);
        System.out.println(sb);
    }
}
