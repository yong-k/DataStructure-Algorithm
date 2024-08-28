package september2024;

import java.util.PriorityQueue;

/**
 * 프로그래머스 - 더 맵게 (240828)
 * https://school.programmers.co.kr/learn/courses/30/lessons/42626
 * */
public class p_42626 {
    public int solution(int[] scoville, int K) {
        // 우선순위 큐(최소힙) 사용
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int s : scoville)
            queue.add(s);

        // 우선순위 큐(최소힙)에 넣고, 맨 앞의 수가 K 이상이 될 때까지 반복한다.
        int answer = 0;
        while (queue.peek() < K) {
            if (queue.size() == 1) return -1;

            int scovilleOfFirstFood = queue.poll();
            int scovilleOfSecondFood = queue.poll();
            queue.add(scovilleOfFirstFood + scovilleOfSecondFood * 2);

            answer++;
        }
        return answer;
    }
}
