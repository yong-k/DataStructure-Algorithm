package daily.f_202410;

import java.util.Collections;
import java.util.TreeSet;

/**
 * 프로그래머스 책 - 문제02) 배열 제어하기
 *
 * 중복값 제거하고 내림차순 정렬해서 반환
 *
 * input  1) [4,2,2,1,3,4]
 * output 1) [4,3,2,1]
 *
 * input  2) [2,1,1,3,2,5,4]
 * output 2) [5,4,3,2,1]
 * */
public class p_02 {
    private static int[] solution(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int num : arr)
            set.add(num);

        int[] result = new int[set.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = set.pollFirst();
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 2, 2, 1, 3, 4};
        int[] result1 = solution(arr1);

        int[] arr2 = {2, 1, 1, 3, 2, 5, 4};
        int[] result2 = solution(arr2);
    }
}
