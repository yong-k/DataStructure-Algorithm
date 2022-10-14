package baekjoon_step.Step19_stack;

import java.io.*;
import java.util.*;
public class B_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0)
                s.pop();
            else
                s.push(input);
        }

        int sum = 0;
        while(!s.isEmpty())
            sum += s.pop();
        System.out.println(sum);
    }
}
