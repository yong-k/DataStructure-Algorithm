package study_250813.greedy;

import java.util.Scanner;

/*
이코테 - 1이 될 때까지
17 4
==> 3

25 5
==> 2
*/
public class G03_this {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int count = 0;
        while (N > 1) {
            if (N % K == 0)
                N /= K;
            else
                N--;
            count++;
        }
        System.out.println(count);
    }
}
