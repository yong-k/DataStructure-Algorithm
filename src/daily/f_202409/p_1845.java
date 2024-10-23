package daily.f_202409;

import java.util.HashSet;
import java.util.Set;

/**
 * 프로그래머스 - 폰켓몬 (240828)
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 * */
public class p_1845 {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums)
            set.add(n);

        return Math.min(nums.length / 2, set.size());
    }
}
