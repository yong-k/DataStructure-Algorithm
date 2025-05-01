package doit_codingTest;

import java.util.Scanner;

public class C009_12891 {
    static int[] answerArr = new int[4];
    static int[] myArr = new int[4];
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int P = sc.nextInt();
        String str = sc.next();

        for (int i = 0; i < 4; i++) {
            answerArr[i] = sc.nextInt();
            if (answerArr[i] == 0)
                cnt++;
        }

        int result = 0;
        for (int i = 0; i < P; i++) {
            add(str.charAt(i));
        }
        if (cnt == 4)
            result++;

        for (int i = P; i < S; i++) {
            add(str.charAt(i));
            remove(str.charAt(i - P));
            if (cnt == 4)
                result++;
        }
        System.out.println(result);
    }

    static void add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == answerArr[0])
                    cnt++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == answerArr[1])
                    cnt++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == answerArr[2])
                    cnt++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == answerArr[3])
                    cnt++;
                break;
        }
    }

    static void remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == answerArr[0])
                    cnt--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == answerArr[1])
                    cnt--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == answerArr[2])
                    cnt--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == answerArr[3])
                    cnt--;
                myArr[3]--;
                break;
        }
    }
}
