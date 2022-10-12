package baekjoon_step.Step09_recursion;

import java.io.*;
public class B039_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 재귀
        //System.out.println(factorial(N));

        // 재귀X
        int sum = 1;
        while(N != 0)
            sum *= N--;
        System.out.println(sum);
    }

    /*
    static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
    */
}
