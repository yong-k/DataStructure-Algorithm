package doit_algorithm.ch05;

// 실습 5-9
// 8퀸 문제 풀이 (행, 열, 대각선 모두 체크)
public class p194p196Q8 {
    static boolean[] flag_a = new boolean[8];   // 행 체크
    static boolean[] flag_b = new boolean[15];  // 대각선(/) 체크
    static boolean[] flag_c = new boolean[15];  // 대각선(\) 체크
    static int[] pos = new int[8];              // 각 열의 퀸 위치

    // p196-Q8
    static void print() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == pos[i])
                    System.out.print("■ ");
                else
                    System.out.print("□ ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    // i열의 알맞은 위치에 퀸 배치
    static void set(int i) {
        for (int j = 0; j < 8; j++) {
            if (flag_a[j] == false                  // j행에 아직 퀸 없음
                && flag_b[i + j] == false           // 대각선(/)에 아직 퀸 없음
                && flag_c[i - j + 7] == false) {    // 대각선(\)에 아직 퀸 없음
               pos[i] = j;
                if (i == 7)
                    print();
                else {
                    flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
                    set(i + 1);
                    flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        set(0);
    }
}
