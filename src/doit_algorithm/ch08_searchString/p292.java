package doit_algorithm.ch08_searchString;

import java.util.Scanner;

// 실습 8-1: 브루트-포스법으로 문자열을 검색
public class p292 {
    static int bfMatch(String txt, String pat) {
        int txtPointer = 0;
        int patPointer = 0;
        int loopCounter = 0;    //--p293_Q1

        while (txtPointer != txt.length() && patPointer != pat.length()) {
            if (txt.charAt(txtPointer) == pat.charAt(patPointer)) {
                txtPointer++;
                patPointer++;
            } else {
                txtPointer = txtPointer - patPointer + 1;
                patPointer = 0;     // 패턴 포인터는 다시 0으로 초기화
            }
            loopCounter++;
        }
        // 검색 성공
        if (patPointer == pat.length()) {
            System.out.println(loopCounter + "번 비교하고 찾음");
            return txtPointer - patPointer;
        }
        // 검색 실패
        return -1;
    }

    // p293-Q2
    // 텍스트에 여러 개의 패턴이 있다면 가장 뒤에 있는거의 인덱스 반환
    static int bfMatchLast(String txt, String pat) {
        int txtPointer = txt.length() - 1;
        int patPointer = pat.length() - 1;
        int loopCounter = 0;    //--p293_Q1

        while (txtPointer >= 0 && patPointer >= 0) {
            if (txt.charAt(txtPointer) == pat.charAt(patPointer)) {
                txtPointer--;
                patPointer--;
            } else {
                txtPointer = txtPointer - patPointer + 1;
                patPointer = pat.length() - 1;
            }
            loopCounter++;
        }
        // 검색 성공
        if (patPointer < 0) {
            System.out.println(loopCounter + "번 비교하고 찾음");
            return txtPointer;
        }
        // 검색 실패
        else
            return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("텍스트: ");
        String text = sc.next();
        System.out.print("패턴: ");
        String pattern = sc.next();

        //int idx = bfMatch(text, pattern);
        int idx = bfMatchLast(text, pattern);
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
