package daily.f_202409;

import java.util.ArrayList;
import java.util.List;

/**
 * 프로그래머스 - 같은 숫자는 싫어 (240827)
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906
 * */
public class p_12906 {
    public int[] solution(int[] arr) {
        int[] answer;
        List<Integer> list = new ArrayList<>();

        // 첫 번째 원소는 추가
        int prev = arr[0];
        list.add(prev);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != prev)
                list.add(arr[i]);
            prev = arr[i];
        }

        answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
