public class T005_1_hashTable {
    public Slot[] hashTable;    // slot 기반으로 배열 생성

    public T005_1_hashTable(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String value;   // 해당 slot에는 String value 저장 가능
        Slot(String value) {
            this.value = value;
        }
    }

    public Integer hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null)
            // 기존 내용 새로운 데이터로 덮어쓰기
            this.hashTable[address].value = value;
        else
            this.hashTable[address] = new Slot(value);
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null)
            return this.hashTable[address].value;
        else
            return null;
    }

    public static void main(String[] args) {
        T005_1_hashTable hash = new T005_1_hashTable(20);
        System.out.println(hash.saveData("yong", "01012123434"));
        System.out.println(hash.saveData("helloworld", "01099998888"));
        System.out.println(hash.getData("yong"));   // 01012123434
        hash.saveData("yaii", "01022223333");
        hash.saveData("yeea", "01045667777");
        System.out.println(hash.getData("yong"));   // 01045667777
    }
}
