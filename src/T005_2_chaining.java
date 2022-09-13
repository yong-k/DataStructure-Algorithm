public class T005_2_chaining {
    public Slot[] hashTable;

    public T005_2_chaining(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String key;
        String value;
        Slot next;  // key가 중복되어 LinkedList가 될 수 있으니 next 필요
        Slot(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            // 둘 다 head 로 초기화
            Slot findSlot = this.hashTable[address];
            Slot prevSlot = this.hashTable[address];
            while (findSlot != null) {
                if (findSlot.key == key) {
                    // 이미 내가 넣고자 하는 키 있다면, 새로운 value로 update
                    findSlot.value = value;
                    return true;
                } else {
                    prevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            //-- while문 끝나면, 해당 LinkedList가 끝난거
            //   LinkedList에 내가 넣고자 하는 키에 해당하는 슬롯 없는거
            // → 그럼 LinkedList의 끝에 넣고자 하는 키 연결해주면 됨
            //-- findSlot은 지금 null인 상태 (prevSlot 사용해서 접근해야 함)
            prevSlot.next = new Slot(key, value);
            return true;
        } else {
            this.hashTable[address] = new Slot(key, value);
            return true;
        }
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            Slot findSlot = this.hashTable[address];
            while (findSlot != null) {
                if (findSlot.key == key)
                    return findSlot.value;
                else
                    findSlot = findSlot.next;
            }
            return null;
        } else
            return null;
    }

    public static void main(String[] args) {
        T005_2_chaining hash = new T005_2_chaining(20);
        System.out.println(hash.saveData("yong", "01012123434"));
        System.out.println(hash.saveData("helloworld", "01099998888"));
        System.out.println(hash.getData("yong"));   // 01012123434
        hash.saveData("yaii", "01022223333");
        hash.saveData("yeea", "01045667777");
        System.out.println(hash.getData("yong"));   // 01012123434
        System.out.println(hash.getData("yaii"));   // 01022223333
    }
}
