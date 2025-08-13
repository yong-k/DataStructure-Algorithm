package doit_codingTest;

import java.util.PriorityQueue;
import java.util.Scanner;

public class C033_1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++)
            pq.add(sc.nextInt());

        int result = 0;
        while (pq.size() > 1) {
            int sum = pq.poll() + pq.poll();
            pq.add(sum);
            result += sum;
        }
        System.out.println(result);
    }
}
