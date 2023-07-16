package codingTestStudy.week1;

import java.util.*;
public class B_1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (char c : arr)
            sb.insert(0, c);
        System.out.println(Integer.parseInt(sb.toString()));
    }
}
