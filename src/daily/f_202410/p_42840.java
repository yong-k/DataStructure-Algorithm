package daily.f_202410;

import java.util.ArrayList;
import java.util.List;

/**
 * 프로그래머스 - 모의고사 (책 문제04)
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840
 * */
public class p_42840 {
    // 2차원 배열에서 각 행의 열 개수 달라도 된다.
    public int[] solution(int[] answers) {
        int[][] pattern = {
                { 1, 2, 3, 4, 5 },
                { 2, 1, 2, 3, 2, 4, 2, 5 },
                { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }
        };
        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if (answers[i] == pattern[j][i % pattern[j].length])
                    scores[j]++;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < scores.length; i++) {
            if (max < scores[i])
                max = scores[i];
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == max)
                list.add(i + 1);
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = list.get(i);
        return result;
    }
}
