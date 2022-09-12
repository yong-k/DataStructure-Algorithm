package doit_algorithm.ch07_set;

public class p278 {
    private int max;    // 집합의 최대 개수
    private int num;    // 집합의 요소 개수
    private int[] set;  // 집합 본체

    // 생성자
    public p278(int capacity) {
        num = 0;
        max = capacity;
        try {
            set = new int[max];         // 집합 배열 생성
        } catch (OutOfMemoryError e) {  // 배열 생성 실패
            max = 0;
        }
    }

    // 집합의 최대 개수
    public int capacity() {
        return max;
    }

    // 집합의 요소 개수
    public int size() {
        return num;
    }

    // 집합에서 n을 검색 (index 반환)
    public int indexOf(int n) {
        for (int i = 0; i < num; i++)
            if (set[i] == n)
                return i;
        return -1;
    }

    // 집합에 n이 있는지 없는지 확인
    public boolean contains(int n) {
        return (indexOf(n) != -1) ? true : false;
    }

    // 집합에 n을 추가
    public boolean add(int n) {
        if (num >= max || contains(n) == true)  // 가득 찼거나 이미 n이 존재함
            return false;
        else {
            set[num++] = n;
            return true;
        }
    }

    // 집합에서 n을 삭제
    public boolean remove(int n) {
        int idx;    // n이 저장된 요소의 인덱스
        if (num <= 0 || (idx = indexOf(n)) == -1)   // 비어있거나 n이 존재하지 않음
            return false;
        else {
            set[idx] = set[--num];  // 마지막 요소를 삭제한 곳으로 옮김
            return true;
        }
    }

    // 집합 arr에 복사
    public void copyTo(p278 arr) {
        int n = (arr.max < num) ? arr.max : num;    // 복사할 요소 개수
        for (int i = 0; i < n; i++)
            arr.set[i] = set[i];
        arr.num = n;
    }

    // 집합 arr를 복사
    public void copyFrom(p278 arr) {
        int n = (max < arr.num) ? max : arr.num;    // 복사할 요소 개수
        for (int i = 0; i < n; i++)
            set[i] = arr.set[i];
        num = n;
    }

    // 집합 arr와 같은지 확인
    public boolean equalTo(p278 arr) {
        // 요소의 개수가 같지 않으면 집합도 같지 않음
        if (num != arr.num)
            return false;

        for (int i = 0; i < num; i++) {
            int j = 0;
            for (; j < arr.num; j++)
                if (set[i] == arr.set[j])
                    break;
            if (j == arr.num)   // set[i] 는 arr에 포함되지 않음
                return false;
        }
        return true;
    }

    // 집합 s1과 s2의 합집합을 복사
    public void unionOf(p278 s1, p278 s2) {
        copyFrom(s1);   // 집합 s1을 복사
        for (int i = 0; i < s2.num; i++)    // 집합 s2의 요소 추가
            add(s2.set[i]);
    }

    // { a b c } 형식의 문자열로 표현
    public String toString() {
        StringBuffer sb = new StringBuffer("{");
        for (int i = 0; i < num; i++)
            sb.append(set[i] + " ");
        sb.append("}");
        return sb.toString();
    }
}
