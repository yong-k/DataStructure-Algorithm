package inflearn_algorithm.ch01_String;

import java.io.*;
public class C06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            flag = true;
            for (int j = 0; j < i; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                sb.append(str.charAt(i));
        }
        System.out.println(sb);
    }
}
