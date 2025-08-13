package doit_codingTest;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C034_1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 1, 0, 음수, 양수
        int oneCount = 0;
        int zeroCount = 0;
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num == 0)
                zeroCount++;
            else if (num == 1)
                oneCount++;
            else if (num > 1)
                plusPq.add(num);
            else
                minusPq.add(num);
        }

        int sum = 0;

        // 음수 2개씩 꺼내서 묶고, 0 있으면 같이 묶고 없으면 sum에 더하기
        while (minusPq.size() > 1) {
            sum += minusPq.poll() * minusPq.poll();
        }
        if (!minusPq.isEmpty()) {
            if (zeroCount <= 0)
                sum += minusPq.poll();
        }

        // 양수 2개씩 꺼내서 묶고, 남은거 더해주기
        while (plusPq.size() > 1) {
            sum += plusPq.poll() * plusPq.poll();
        }
        if (!plusPq.isEmpty()) {
            sum += plusPq.poll();
        }

        // 1은 개수만큼 더해주기
        sum += oneCount;

        System.out.println(sum);
    }
}
