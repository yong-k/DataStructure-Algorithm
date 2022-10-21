
import java.io.*;
import java.util.*;
public class T999_practice<T> {
    public static int solution(int num) {
        int answer = 0;
        if (num == 1)
            return 0;
        while (answer < 500) {
            answer++;
            if (num % 2 == 0)
                num /= 2;
            else
                num = num * 3 + 1;
            if (num == 1) break;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(626331));
    }


}

