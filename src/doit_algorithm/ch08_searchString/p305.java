package doit_algorithm.ch08_searchString;

import java.util.Scanner;

// 실습 8-4: Boyer-Moore법
public class p305 {
    static int bmMatch(String txt, String pat) {
        int txtPointer;
        int patPointer;
        int txtLen = txt.length();  // txt의 문자 개수
        int patLen = pat.length();  // pat의 문자 개수
        int[] skip = new int[Character.MAX_VALUE + 1];  // 건너뛰기 표
        int loopCounter = 0;

        // 건너뛰기 표 만듦
        for (txtPointer = 0; txtPointer < Character.MAX_VALUE; txtPointer++)
            skip[txtPointer] = patLen;  //-- 일단 다 패턴 길이로 초기화
        for (txtPointer = 0; txtPointer < patLen - 1; txtPointer++)
            skip[pat.charAt(txtPointer)] = patLen - txtPointer - 1;

        //----------└→ 여기까지 하면, 『txtPointer == patLen - 1』
        // 검색
        while (txtPointer < txtLen) {
            patPointer = patLen - 1;    // pattern의 끝 문자에 주목

            while (txt.charAt(txtPointer) == pat.charAt(patPointer)) {
                if (patPointer == 0) {
                    System.out.println(loopCounter + "번 비교하고 찾음");
                    return txtPointer;  // 검색 성공
                }
                txtPointer--;
                patPointer--;
            }
            txtPointer += (skip[txt.charAt(txtPointer)] > patLen - patPointer)
                    ? skip[txt.charAt(txtPointer)] : patLen - patPointer;

            loopCounter++;
        }
        return -1;  // 검색 실패
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("텍스트: ");
        String text = sc.next();
        System.out.print("패턴: ");
        String pattern = sc.next();

        int idx = bmMatch(text, pattern);
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
