package baekjoon_step.Step03_loop;

// 1110
import java.util.*;
public class B013_1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int n = sc.nextInt();
        int change = n;

        do {
            change = ((change % 10) * 10) + (((change / 10) + (change % 10)) % 10);
            System.out.println(change);
            count++;
        } while (change != n);

        System.out.println(count);
    }
}
