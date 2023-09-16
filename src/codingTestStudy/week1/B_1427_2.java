package codingTestStudy.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class B_1427_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N.length(); i++)
            list.add(N.charAt(i) - '0');

        Collections.sort(list, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int i : list)
            sb.append(i);
        System.out.println(Integer.parseInt(sb.toString()));
    }
}
