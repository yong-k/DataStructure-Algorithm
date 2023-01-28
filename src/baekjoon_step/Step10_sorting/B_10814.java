package baekjoon_step.Step10_sorting;

import java.io.*;
import java.util.*;

public class B_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Member[] arr = new Member[N];
        int order = 1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken(), order++);
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.age == o2.age)
                return o1.order - o2.order;
            return o1.age - o2.age;
        });

        for (int i = 0; i < N; i++)
            System.out.println(arr[i].age + " " + arr[i].name);
    }

    static class Member {
        int age;
        String name;
        int order;

        public Member(int age, String name, int order) {
            this.age = age;
            this.name = name;
            this.order = order;
        }
    }
}
