import java.util.*;

public class T999_practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Double> stack = new Stack<>();
        int[] arr = new int[N];

        String str = sc.next();
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                stack.push((double) arr[c - 'A']);
            } else {
                double num2 = stack.pop();
                double num1 = stack.pop();
                switch (c) {
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
