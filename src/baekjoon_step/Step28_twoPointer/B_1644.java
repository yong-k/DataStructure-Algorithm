package baekjoon_step.Step28_twoPointer;

import java.io.*;
import java.util.ArrayList;

public class B_1644 {
    static int N;
    static boolean[] prime;
    static ArrayList<Integer> primeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        prime = new boolean[N + 1];
        get_prime();

        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 2;
        int primeNum = primeList.size();
        while (left < primeNum && right < primeNum) {
            if (sum > N) {
                sum -= primeList.get(left);
                left++;
            } else if (sum < N) {
                right++;
                if (right >= primeNum) break;
                sum += primeList.get(right);
            } else {
                count++;
                sum -= primeList.get(left);
                left++;
            }
        }
        System.out.println(count);
    }

    // 에라토스테네스의 체: 소수 구하기
    static void get_prime() {
        prime[0] = prime[1] = true;
        for (int i = 2; i < Math.sqrt(prime.length); i++) {
            if (prime[i]) continue;
            for (int j = i*i; j < prime.length; j += i)
                prime[j] = true;
        }

        for (int i = 2; i < prime.length; i++)
            if (!prime[i])
                primeList.add(i);
    }
}
