import java.util.ArrayList;

public class T999_practice<T> {
    static ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> list) {
        if (list.size() <= 1)
            return list;

        ArrayList<Integer> leftList, rightList;
        int medium = list.size() / 2;

        leftList = mergeSplitFunc(new ArrayList<>(list.subList(0, medium)));
        rightList = mergeSplitFunc(new ArrayList<>(list.subList(medium, list.size())));

        return mergeFunc(leftList, rightList);
    }

    static ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergeList = new ArrayList<>();
        int leftPoint = 0, rightPoint = 0;

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
        for (int i = 0; i < 20; i++)
            list.add((int)(Math.random()*100));

        System.out.println(mergeSplitFunc(list));
    }
}

