package inflearn_algorithm.ch01_String;

import java.util.*;
public class C01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = (sc.next()).toLowerCase();
        char search = Character.toLowerCase((sc.next()).charAt(0));
        int count = 0;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == search)
                count++;
        System.out.println(count);
    }
}
