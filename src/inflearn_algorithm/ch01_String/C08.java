package inflearn_algorithm.ch01_String;

import java.io.*;
public class C08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int s = 0;
        int e = str.length() - 1;
        boolean flag = true;
        while (s < e) {
            char charS = Character.toUpperCase(str.charAt(s));
            char charE = Character.toUpperCase(str.charAt(e));
            // 둘 다 알파벳
            if ((charS >= 65 && charS <= 90) && (charE >= 65 && charE <= 90)) {
                if (charS != charE) {
                    flag = false;
                    break;
                }
                s++;
                e--;
            } else if (charS >= 65 && charS <= 90)
                e--;
            else if (charE >= 65 && charE <= 90)
                s++;
            else {
                s++;
                e--;
            }
        }
        if (flag)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
