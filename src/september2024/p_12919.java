package september2024;

import java.util.Arrays;

/**
 * 프로그래머스 - 서울에서 김서방 찾기 (240828)
 * https://school.programmers.co.kr/learn/courses/30/lessons/12919
 * */
public class p_12919 {
    public String solution(String[] seoul) {
        return "김서방은 " + Arrays.asList(seoul).indexOf("Kim") + "에 있다";
    }
}
