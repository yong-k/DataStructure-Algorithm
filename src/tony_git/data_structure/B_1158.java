package tony_git.data_structure;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_1158 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++)
            queue.add(i);

        int num = 1;
        sb.append('<');
        while (!queue.isEmpty()) {
            if (num % K == 0)
                sb.append(queue.poll()).append(", ");
            else
                queue.add(queue.poll());

            num++;
        }

        sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length()-1);
        sb.append('>');
        System.out.println(sb);
    }
}
