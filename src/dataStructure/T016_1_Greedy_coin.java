package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class T016_1_Greedy_coin {
    // 내 풀이(먼저 풀어봄)
    static void my_coinFunc(int price, ArrayList<Integer> coinList) {
        int totalPrice = price;
        int totalCoin = 0;
        ArrayList<Integer> coinCount = new ArrayList<>();
        for (int i = 0; i < coinList.size(); i++) {
            coinCount.add(i, totalPrice / coinList.get(i));
            totalPrice %= coinList.get(i);
            System.out.printf("%d원 → %d개\n", coinList.get(i), coinCount.get(i));
            totalCoin += coinCount.get(i);
        }
        System.out.println("총 동전 개수 → " + totalCoin + "개");
    }

    static void coinFunc(Integer price, ArrayList<Integer> coinList) {
        Integer totalCoinCount = 0;     // 최종 동전 개수
        Integer coinNum = 0;            // 각각 동전의 개수
        ArrayList<Integer> details = new ArrayList<>();

        for (int i = 0; i < coinList.size(); i++) {
            coinNum = price / coinList.get(i);
            totalCoinCount += coinNum;
            price -= coinNum * coinList.get(i);
            details.add(coinNum);
            System.out.println(coinList.get(i)+"원: " + coinNum + "개");
        }
        System.out.println("총 동전 개수: " + totalCoinCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> coinList = new ArrayList<>(Arrays.asList(500, 100, 50, 1));
        System.out.print("금액 입력: ");
        int price = sc.nextInt();
        my_coinFunc(price, coinList);
        System.out.println();
        coinFunc(price, coinList);
    }
}
