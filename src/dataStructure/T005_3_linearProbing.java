package dataStructure;

public class T005_3_linearProbing {
    public Slot[] hashTable;

    public T005_3_linearProbing(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        // 해당 slot에 있는 데이터가 내 key에 대한 value인지 확인해야 함
        String key;
        String value;
        Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            // 해당 키가 내 키와 맞는지 확인 → 맞으면 새로운 value로 update
            if (this.hashTable[address].key == key) {
                this.hashTable[address].value = value;
                return true;
            } else {
                // 비어있는 슬롯을 찾아서 한 칸 이동
                Integer currAddress = address + 1;
                // 해당 주소에 있는 슬롯이 key인지 확인
                //while (this.hashTable[currAddress].key == key) {}
                //--> 해당 슬롯이 없을 수도 있으니, 아래 코드를 먼저 작성
                //    다음 슬롯이 있는지(널이 아닌지) 먼저 체크!
                while (this.hashTable[currAddress] != null) {
                    // 해당 키가 내 키와 맞는지 확인 → 맞으면 새로운 value로 update
                    if (this.hashTable[currAddress].key == key) {
                        this.hashTable[currAddress].value = value;
                        return true;
                    } else {
                        currAddress++;  //-- 슬롯 한 칸 뒤로 이동
                        if (currAddress >= this.hashTable.length)
                            return false;
                    }
                }
                //--while 문 종료 시, 해당 슬롯이 아예 없다는 뜻
                //  hashTable의 length 만큼 currAddress가 되면 아예 종료(return)되니까
                //  (currAddress에 해당하는 Slot이 null이라는 뜻)
                //  → 새로운 slot에 저장해주면 된다.
                this.hashTable[currAddress] = new Slot(key, value);
                return true;
            }
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key)
                return this.hashTable[address].value;
            else {
                Integer currAddress = address + 1;
                while (this.hashTable[currAddress] != null) {
                    if (this.hashTable[currAddress].key == key)
                        return this.hashTable[currAddress].value;
                    else {
                        currAddress++;
                        if (currAddress >= this.hashTable.length)
                            return null;
                    }
                }
                return null;
            }
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        T005_3_linearProbing hash = new T005_3_linearProbing(20);
        System.out.println(hash.saveData("yong", "01012123434"));
        System.out.println(hash.saveData("helloworld", "01099998888"));
        System.out.println(hash.getData("yong"));   // 01012123434
        hash.saveData("yaoi", "01022223333");
        hash.saveData("yeea", "01045667777");
        System.out.println(hash.getData("yong"));   // 01012123434
        System.out.println(hash.getData("yaoi"));   // 01022223333
    }
}
