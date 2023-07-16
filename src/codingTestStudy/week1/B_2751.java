package codingTestStudy.week1;

import java.io.*;
import java.util.*;
public class B_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++)
            list.add(Integer.parseInt(br.readLine()));

        Collections.sort(list);

        for (int i : list)
            sb.append(i).append('\n');
        System.out.println(sb);
    }
}
