package codingTestStudy.week1;

import java.util.*;
public class B_10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Member> list = new ArrayList<>();

        for (int i = 0; i < N; i++)
            list.add(new Member(i, sc.nextInt(), sc.next()));

        Collections.sort(list, (o1, o2) ->  {
            if (o1.age == o2.age)
                return o1.order - o2.order;
            return o1.age - o2.age;
        });

        StringBuilder sb = new StringBuilder();
        for (Member m : list)
            sb.append(m.age + " " + m.name).append('\n');
        System.out.println(sb);
    }

    static class Member {
        int order;
        int age;
        String name;

        public Member(int order, int age, String name) {
            this.order = order;
            this.age = age;
            this.name = name;
        }
    }
}
