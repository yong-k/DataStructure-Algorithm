package baekjoon;

/*
등차수열
두 항의 차이를 d라고 할 때,
a의 n번째 항 = a₁ + (n - 1)*d
*/
import java.io.*;
public class B019_1065 {
    static int hansu(int n) {
        int count = 0;
        int d = 0;
        boolean flag = true;

        if (n < 100)
            count = n;
        else {
            count = 99;
            for (int i = 100; i <= n; i++) {
                int j = i;
                d = (j % 10) - (j / 10 % 10);
                j /= 10;
                flag = true;
                while (j > 0) {
                    if (d != (j % 10) - (j / 10 % 10)) {
                        flag = false;
                        break;
                    }
                    j /= 10;
                    j /= 10;
                }
                if (flag == true)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(hansu(Integer.parseInt(br.readLine())));
    }
}
