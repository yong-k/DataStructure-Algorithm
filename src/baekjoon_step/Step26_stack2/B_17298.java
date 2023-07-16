package baekjoon_step.Step26_stack2;

import java.io.*;
import java.util.*;
/*
4
3 5 2 7

4
9 5 4 8
*/
public class B_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[4];
        int[] answer = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        stack.push(0);  //index 넣음
        for (int i = 1; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i])
                answer[stack.pop()] = arr[i];
            stack.push(i);
        }
        while (!stack.isEmpty())
            answer[stack.pop()] = -1;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0 ; i < N; i++)
            bw.write(answer[i] + " ");
        bw.flush();
    }
}
