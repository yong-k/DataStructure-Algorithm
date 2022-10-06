package baekjoon_step.Step06_string;

import java.io.*;
public class B024_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = (br.readLine()).toUpperCase();
        int[] alphabet = new int[26];

        for (int i = 0; i < str.length(); i++)
            alphabet[(int)str.charAt(i) - 65]++;

        /*
        int maxIdx = 0;
        for (int i = 1; i < alphabet.length; i++)
            if (alphabet[maxIdx] < alphabet[i])
                maxIdx = i;

        int maxCount = 0;
        for (int i = 0; i < alphabet.length; i++)
            if (alphabet[maxIdx] == alphabet[i])
                maxCount++;

        if (maxCount > 1)
            System.out.println("?");
        else
            System.out.println((char)(maxIdx + 65));
        */

        int max = -1;
        char ch = '?';
        for (int i = 0; i < alphabet.length; i++) {
            if (max < alphabet[i]) {
                max = alphabet[i];
                ch = (char)(i + 65);
            }
            else if (max == alphabet[i])
                ch = '?';
        }
        System.out.println(ch);
    }
}
