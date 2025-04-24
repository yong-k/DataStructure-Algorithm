package tony_git.data_structure;

import java.util.*;

/*
후위표기식 계산
https://siyoon210.tistory.com/2
*/
public class B_1935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] values = new int[N];   // N개의 알파벳에 해당하는 값 저장해놓을 배열
        String s = sc.next();
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < N; i++)
            values[i] = sc.nextInt();

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (now >= 'A' && now <= 'Z')
                stack.push((double) values[now - 'A']);
            else {
                double num2 = stack.pop();
                double num1 = stack.pop();
                switch (now) {
                    case '+':
                        stack.push(num1 + num2);
                        break;
                    case '-':
                        stack.push(num1 - num2);
                        break;
                    case '*':
                        stack.push(num1 * num2);
                        break;
                    case '/':
                        stack.push(num1 / num2);
                        break;
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
