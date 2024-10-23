package daily.f_202409;

import java.util.Arrays;

/**
 * 프로그래머스 - 문자열 내 마음대로 정렬하기 (240828)
 * https://school.programmers.co.kr/learn/courses/30/lessons/12915
 * */
public class p_12915 {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            if (s1.charAt(n) == s2.charAt(n))
                return s1.compareTo(s2);
            return s1.charAt(n) - s2.charAt(n);
        });
        return strings;
    }
}
