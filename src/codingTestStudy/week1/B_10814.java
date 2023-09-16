package codingTestStudy.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class B_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Member> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Member(i, age, name));
        }

        // 나이 순 오름차순 정렬
        // 나이 같으면, 먼저 입력한 순서(order) 오름차순 정렬
        Collections.sort(list, (m1, m2) -> {
            if (m1.age == m2.age)
                return m1.order - m2.order;
            return m1.age - m2.age;
        });

        StringBuilder sb = new StringBuilder();
        for (Member m : list)
            sb.append(m.age).append(' ').append(m.name).append('\n');
        System.out.print(sb);
    }
}

class Member {
    int order;
    int age;
    String name;

    public Member(int order, int age, String name) {
        this.order = order;
        this.age = age;
        this.name = name;
    }
}
