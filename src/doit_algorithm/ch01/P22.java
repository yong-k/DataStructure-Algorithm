package doit_algorithm.ch01;

// p22-Q4: 중앙값 (정렬 사용)
public class P22 {
    static int med3(int a, int b, int c, int d, int e) {
        int arr[] = {a, b, c, d, e};
        /*
        flag 사용 → 한바퀴 도는 동안 자리바꿈 0번이면 stop
        1)
        4 5 2 1
        - -
          - -
            - -
        */
         boolean flag = false;
         int temp = 0;
         for (int i = 0; i < arr.length; i++) {
             flag = false;
             for (int j = 0; j < arr.length-1; j++) {
                 if (arr[j] > arr[j+1]) {
                     // 같은 메모리 공간을 참조하는 경우 XOR교환 동작 Ⅹ
                     /*
                     arr[j] = arr[j] ^ arr[j+1];
                     arr[j+1] = arr[j+1] ^ arr[j];
                     arr[j] = arr[j] ^ arr[j+1];
                     */
                     temp = arr[j];
                     arr[j] = arr[j+1];
                     arr[j+1] = temp;
                     flag = true;
                 }
             }
         }
         // arr.length는 4여서 짝수여도, index 번호는 0부터 시작하기 때문에
         // 이렇게 하려면 -1 해줘야됨
         /*
         if (arr.length % 2 == 0)
             return arr[arr.length/2];
         else
             return arr[arr.length/2+1];
         */
         return arr[arr.length/2];
    }

    public static void main(String[] args) {
        System.out.println(med3(4, 2, 5, 1, 9));
        System.out.println(med3(9, 1, 5, 4, 2));
        System.out.println(med3(5, 9, 4, 1, 2));
        System.out.println(med3(9, 2, 5, 1, 4));
    }
}