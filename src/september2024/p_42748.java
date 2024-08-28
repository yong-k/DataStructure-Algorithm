package september2024;

import java.util.*;

/**
 * 프로그래머스 - K번째수 (240828)
 * https://school.programmers.co.kr/learn/courses/30/lessons/42748
 * */
public class p_42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();

            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                queue.add(array[j]);
            }

            // K번째 숫자 찾기
            for (int k = 0; k < commands[i][2]; k++) {
                answer[i] = queue.poll();
            }
        }
        return answer;
    }
}

/*
* 다른 방법: Arrays.copyOfRange();
*
* int[] answer = new int[commands.length];
* for (int i = 0; i < commands.length; i++) {
*   // 자르고, 정렬 후 K번째 수
*   int[] arr = Arrays.copyOfRange(arrray, commands[i][0] - 1, commands[i][1]);
*   Arrays.sort(arr);
*   answer[i] = arr[commands[i][2] - 1];
* }
* return answer;
* */
