package daily.f_202410;

import java.util.TreeSet;

/**
 * 프로그래머스 - 두 개 뽑아서 더하기 (책 문제03)
 * https://school.programmers.co.kr/learn/courses/30/lessons/68644
 * */
public class p_68644 {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> set = new TreeSet<>();
        int[] result;

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        result = new int[set.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = set.pollFirst();

        return result;
    }
}
