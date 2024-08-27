package dataStructure;

import java.util.ArrayList;
import java.util.Collections;

public class T007_heap {
    public ArrayList<Integer> heapArray = null;

    public T007_heap(Integer data) {
        heapArray = new ArrayList<>();

        heapArray.add(null);    // 편의 위해서, 0번째에는 null
        heapArray.add(data);
    }

    // insert할 때, 맨 마지막에 넣어서 해당 서브트리의 루트와 비교하며 move_up 할 예정
    public boolean move_up(Integer inserted_idx) {
        // 루트노드라면,
        if (inserted_idx <= 1)
            return false;
        Integer parent_idx = inserted_idx / 2;
        if (this.heapArray.get(inserted_idx) > this.heapArray.get(parent_idx))
            return true;
        else
            return false;
    }

    public boolean insert(Integer data) {
        Integer inserted_idx, parent_idx;

        if (heapArray == null) {
            heapArray = new ArrayList<>();
            heapArray.add(null);
            heapArray.add(data);
            return true;
        }

        this.heapArray.add(data);
        inserted_idx = this.heapArray.size() - 1;
        while (this.move_up(inserted_idx)) {
            parent_idx = inserted_idx / 2;
            Collections.swap(this.heapArray, inserted_idx, parent_idx);
            inserted_idx = parent_idx;
        }
        return true;
    }

    // pop 할 때, 루트 꺼내고, 제일 마지막꺼를 루트로 올린 후, 자식 노드들과 비교하면서 move_down 할 예쩡
    public boolean move_down(Integer popped_idx) {
        Integer left_child_popped_idx, right_child_popped_idx;
        left_child_popped_idx = popped_idx * 2;
        right_child_popped_idx = popped_idx * 2 + 1;

        // CASE1: 왼쪽 자식 노드도 없을 때 (완전이진트리이기 때문에 왼쪽 자식 없이 오른쪽 자식만 있을 수는 없음)
        //--(자식 노드가 하나도 없을 때)
        if (left_child_popped_idx >= this.heapArray.size())
            return false;

        // CASE2: 오른쪽 자식 노드만 없을 때 (왼쪽 자식 노드만 있을 때)
        else if (right_child_popped_idx >= this.heapArray.size()) {
            // 왼쪽 자식 노드와 현재 노드의 값 비교하면 됨
            if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx))
                return true;
            else
                return false;

            // CASE3: 왼쪽/오른쪽 자식 노드가 모두 있을 때
        } else {
            if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
                if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx))
                    return true;
                else
                    return false;
            } else {
                if (this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx))
                    return true;
                else
                    return false;
            }
        }
    }

    public Integer pop() {
        Integer returned_data;  // pop()을 통해 가져올 데이터
        Integer popped_idx;     // 지금 비교해야 할 idx 번호
        Integer left_child_popped_idx, right_child_popped_idx;  // 그 노드의 왼쪽/오른쪽 자식 노드의 idx번호

        if (this.heapArray == null)
            return null;
        else {
            // 리턴할 데이터에 루트노드 저장
            returned_data = this.heapArray.get(1);

            // 맨 마지막 노드 값을 루트로 set
            this.heapArray.set(1, this.heapArray.get(this.heapArray.size() - 1));

            // 그리고 맨 마지막 leaf node 삭제
            this.heapArray.remove(this.heapArray.size() - 1);

            // 현재 체크해야 할 노드는 루트 노드
            popped_idx = 1;

            while (this.move_down(popped_idx))  {
                left_child_popped_idx = popped_idx * 2;
                right_child_popped_idx = popped_idx * 2 + 1;

                // CASE1 은 move_down()에서 false로 되기 때문에 여기 들어오지 못함

                // CASE2: 오른쪽 자식 노드만 없을 때
                if (right_child_popped_idx >= this.heapArray.size()) {
                    // 아래 if 조건문은 안 넣어도 되는 건데 명시적으로 넣음
                    if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                        Collections.swap(this.heapArray, popped_idx, left_child_popped_idx);
                        popped_idx = left_child_popped_idx;
                    }

                // CASE3: 왼쪽/오른쪽 자식 노드 모두 있을 때
                } else {
                    if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
                        // 아래 if 조건문은 안 넣어도 되는 건데 명시적으로 넣음
                        if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                            Collections.swap(heapArray, popped_idx, left_child_popped_idx);
                            popped_idx = left_child_popped_idx;
                        }
                    } else {
                        // 아래 if 조건문은 안 넣어도 되는 건데 명시적으로 넣음
                        if (this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) {
                            Collections.swap(heapArray, popped_idx, right_child_popped_idx);
                            popped_idx = right_child_popped_idx;
                        }
                    }
                }
            }
            return returned_data;
        }
    }

    public static void main(String[] args) {
        T007_heap heap = new T007_heap(15);
        System.out.println(heap.heapArray);     // [null, 15]
        heap.insert(10);
        heap.insert(8);
        heap.insert(5);
        heap.insert(4);
        heap.insert(20);
        System.out.println(heap.heapArray);     // [null, 20, 10, 15, 5, 4, 8]
        heap.pop();
        System.out.println(heap.heapArray);     // [null, 15, 10, 8, 5, 4]
    }
}
