import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class T016_2_Greedy_knapsack {
    // <부분배낭문제구현>
    // 내 풀이(먼저 풀어봄)
    static void my_knapsackFunc(Integer[][] objectList, double capacity) {
        // 물건 쪼갤 수 있다니까, 무게 당 가치 큰 거부터 다 넣어버림 (가치 / 무게)

        double[][] valuePerWeight = new double[objectList.length][2];
        double totalValue = 0.0;
        double fraction = 0.0;

        for (int i = 0; i < objectList.length; i++) {
            valuePerWeight[i][0] = i;
            valuePerWeight[i][1] = (double) objectList[i][1] / objectList[i][0];
        }

        while (capacity > 0.0) {
            int maxIdx = 0;
            double max = 0.0;
            for (int i = 0; i < valuePerWeight.length; i++) {
                if (max < valuePerWeight[i][1]) {
                    max = valuePerWeight[i][1];
                    maxIdx = (int) valuePerWeight[i][0];
                }
            }
            if (capacity - objectList[maxIdx][0] >= 0.0) {
                capacity -= objectList[maxIdx][0];
                totalValue += objectList[maxIdx][1];
                System.out.printf("무게: %d, 가치: %d\n"
                        , objectList[maxIdx][0], objectList[maxIdx][1]);
            } else {
                fraction = capacity / objectList[maxIdx][0];
                capacity = 0;
                totalValue += objectList[maxIdx][1] * fraction;
                System.out.printf("무게: %d, 가치: %d, 비율: %.2f\n"
                        , objectList[maxIdx][0], objectList[maxIdx][1], fraction);
            }
            valuePerWeight[maxIdx][1] = -1.0;
        }
        System.out.printf("총 담은 가치: %.1f\n", totalValue);
    }

    static void knapsackFunc(Integer[][] objectList, double capacity) {
        double totalValue = 0.0;    // 최대 가치
        double fraction = 0.0;      // 해당 물건 몇 % 들어갔는지 계산위한 변수

        Arrays.sort(objectList, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] object1, Integer[] object2) {
                // object[0] : 무게, object[1] = 가치
                // 무게 당 가치(가치/무게)가 큰 게 좋은거니까
                // 내림차순으로 정렬해야 함
                return (object2[1] / object2[0]) - (object1[1] / object1[0]);
            }
        });

        for (int i = 0; i < objectList.length; i++) {
            // 쪼갤 필요 없이 물건 다 들어갈 수 있는 경우
            if (capacity - (double)objectList[i][0] > 0) {
                capacity -= (double) objectList[i][0];
                totalValue += (double) objectList[i][1];
                System.out.println("무게: " + objectList[i][0] + ", 가치: " + objectList[i][1]);
            } else {
                fraction = capacity / (double) objectList[i][0];
                // capacity 이제 다 채워진거니까 0 → 계산해 줄 필요 X
                totalValue += (double) objectList[i][1] * fraction;
                System.out.println("무게: " + objectList[i][0] + ", 가치: " + objectList[i][1] + ", 비율: " + fraction);

                // capacity 꽉 찼으니까 다음 것들 볼 필요 없음. 어차피 못 들어감
                break;
            }
        }
        System.out.println("총 담을 수 있는 가치: " + totalValue);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[][] objectList = { {10, 10} ,{15, 12}, {20, 10}, {25, 8}, {30, 5}};
        my_knapsackFunc(objectList, 30.0);
        System.out.println();
        knapsackFunc(objectList, 30.0);
    }
}
