import java.util.ArrayList;

public class T999_practice<T> {
    static boolean binarySearch(ArrayList<Integer> list, Integer searchedItem) {
        if (list.size() ==1 && searchedItem == list.get(0))
            return true;
        if (list.size() == 1 && searchedItem != list.get(0))
            return false;
        if (list.size() == 0)
            return false;

        int medium = list.size() / 2;

        if (searchedItem == list.get(medium))
            return true;
        else {
            if (searchedItem < list.get(medium))
                return binarySearch(new ArrayList<>(list.subList(0, medium)), searchedItem);
            else
                return binarySearch(new ArrayList<>(list.subList(medium, list.size())), searchedItem);

        }
    }
}

