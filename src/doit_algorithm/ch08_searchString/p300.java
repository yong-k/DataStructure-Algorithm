package doit_algorithm.ch08_searchString;

import java.util.Scanner;

// 실습 8-3 : KMP 법
public class p300 {
    static int kmpMatch(String txt, String pat) {
        int txtPointer = 1;     //--패턴을 텍스트의 한 칸 뒤로 옮겨서부터 비교 시작해야하므로
        int patPointer = 0;
        int[] skip = new int[pat.length() + 1];     // 건너뛰기 표
        int loopCounter = 0;    //--p301_Q1

        // 건너뛰기 표 만듦
        skip[txtPointer] = 0;
        while (txtPointer != pat.length()) {
            if (pat.charAt(txtPointer) == pat.charAt(patPointer))
                skip[++txtPointer] = ++patPointer;
            else if (patPointer == 0)   //-- 문자 다름 + pattern pointer의 위치 0
                skip[++txtPointer] = patPointer;
            else                        //-- 문자 다름 + pattern pointer의 위치 0이 아님
                patPointer = skip[patPointer];
                //-- 다음 시작할 때, 이 위치부터 검사 시작
        }

        // 검색
        txtPointer = patPointer = 0;
        while (txtPointer != txt.length() && patPointer != pat.length()) {
            if (txt.charAt(txtPointer) == pat.charAt(patPointer)) {
                txtPointer++;
                patPointer++;
            } else if (patPointer == 0) {
                txtPointer++;
            } else {
                patPointer = skip[patPointer];
            }
            loopCounter++;
        }

        if (patPointer == pat.length()) {
            System.out.println(loopCounter + "번 비교하고 찾음");
            return txtPointer - patPointer;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("텍스트: ");
        String text = sc.next();
        System.out.print("패턴: ");
        String pattern = sc.next();

        int idx = kmpMatch(text, pattern);
        if (idx == -1)
            System.out.println("텍스트에 패턴 없음");
        else {
            // 일치하는 문자 바로 앞까지의 길이를 구함
            int len = 0;
            for (int i = 0; i < idx; i++)
                len++;
            len += pattern.length();

            System.out.println((idx+1) + "번째 문자부터 일치합니다.");
            System.out.println("텍스트: " + text);
            System.out.printf(String.format("패턴: %%%ds\n", len), pattern);
        }
    }
}
