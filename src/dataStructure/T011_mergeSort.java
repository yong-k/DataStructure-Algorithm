package dataStructure;

import java.util.ArrayList;

public class T011_mergeSort {
    // 리스트 요소가 1개면 해당 값 리턴
    // 1개 이상이면 리스트를 앞/뒤 2개로 나누기
    static ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> list) {
        if (list.size() <= 1)
            return list;

        int medium = list.size() / 2;

        ArrayList<Integer> leftList, rightList;

        leftList = mergeSplitFunc(new ArrayList<Integer>(list.subList(0, medium)));
        rightList = mergeSplitFunc(new ArrayList<Integer>(list.subList(medium, list.size())));

        return mergeFunc(leftList, rightList);
    }

    static ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergeList = new ArrayList<>();
        int leftPoint = 0;
        int rightPoint = 0;

        // CASE1: left/right 둘 다 있을 때
        while (leftList.size() > leftPoint && rightList.size() > rightPoint) {
            if (leftList.get(leftPoint) > rightList.get(rightPoint)) {
                mergeList.add(rightList.get(rightPoint));
                rightPoint++;
            } else {
                mergeList.add(leftList.get(leftPoint));
                leftPoint++;
            }
        }

        // CASE2: right 데이터가 없을 때
        while (leftList.size() > leftPoint) {
            mergeList.add(leftList.get(leftPoint));
            leftPoint++;
        }

        // CASE3: left 데이터가 없을 때
        while (rightList.size() > rightPoint) {
            mergeList.add(rightList.get(rightPoint));
            rightPoint++;
        }

        return mergeList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 15; i++)
            list.add((int)(Math.random() * 100));

        System.out.println(mergeSplitFunc(list));

    }
}

// Arrays.asList(arr); → 일반 배열을 ArrayList로 변환
