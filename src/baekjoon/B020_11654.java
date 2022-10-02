package baekjoon;

import java.io.*;
import java.util.*;

public class B020_11654 {
    public static void main(String[] args) throws IOException {
        // Scanner 사용해서 sc.next().charAt(0) 할 수는 있는데
        // → 성능 좋지 않음
        /*
        Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);
        System.out.println((int)c);
        */

        // System.in.read()
        int ascii = System.in.read();
        System.out.println(ascii);

    }
}
