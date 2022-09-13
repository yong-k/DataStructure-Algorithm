public class T006_tree {
    Node head = null;
    public class Node {
        Node left;
        Node right;
        int value;
        public Node(int data) {
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }

    public boolean insertNode(int data) {
        // CASE1: Node가 하나도 없을 때
        if (this.head == null)
            this.head = new Node(data);
        // CASE2: Node가 하나 이상 들어있을 때
        else {
            Node findNode = this.head;
            while (true) {
                // CASE2-1: 현재 Node의 왼쪽에 Node가 들어가야 할 때
                if (data < findNode.value) {
                    // findNode의 왼쪽에 자식 노드가 있다면,
                    if (findNode.left != null)
                        findNode = findNode.left;
                    else {
                        findNode.left = new Node(data);
                        break;
                    }
                // CASE2-2: 현재 Node의 오른쪽에 Node가 들어가야 할 때
                } else {
                    // findNode의 오른쪽에 자식 노드가 있다면,
                    if (findNode.right != null)
                        findNode = findNode.right;
                    else {
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
            //-- while문이 끝난 경우 → break를 만났을 때
        }
        // if-else 둘 다 끝내면 노드를 생성된 거
        return true;
    }

    public Node search(int data) {
        // CASE1: Node가 하나도 없을 때
        if (this.head == null)
            return null;
        // CASE2: Node가 하나 이상 있을 때
        else {
            Node findNode = this.head;
            while (findNode != null) {
                if (findNode.value == data)
                    return findNode;
                else if (data < findNode.value)
                    findNode = findNode.left;
                else
                    findNode = findNode.right;
            }
            //-- while문 종료: 다 찾아봤는데 해당 노드 없음
            return null;
        }
    }

    public boolean delete(int value) {
        boolean searched = false;

        Node currParentNode = this.head;
        Node currNode = this.head;

        // 코너 케이스1: Node가 하나도 없을 때
        if (this.head == null)
            return false;
        else {
            // 코너 케이스2: Node가 단지 하나만 있고, 해당 Node가 삭제할 Node일 때
            if (this.head.value == value && this.head.left == null && this.head.right == null) {
                this.head = null;
                return true;
            }

            while (currNode != null) {
                if (currNode.value == value) {
                    searched = true;
                    break;
                } else if (value < currNode.value) {
                    currParentNode = currNode;
                    currNode = currNode.left;
                } else {
                    currParentNode = currNode;
                    currNode = currNode.right;
                }
            }
            //-- while문 종료, 2가지 경우 있음
            //   1) 노드 찾은 경우 (if문에서 break)
            //   2) 노드 못 찾은 경우 (currNode == null 인 경우)
            //--> searched 로 판단해주면 됨
            if (searched == false)
                return false;
        }
        //-- searched 가 true인 경우에 여기로 옴
        // 여기까지 실행되면,
        // currNode 에는 해당 데이터를 가지고 있는 Node,
        // currParentNode 에는 해당 데이터를 가지고 있는 Node 의 부모 Node 가 들어있음

        // ↓↓↓ 이제부터 삭제 ㄱㄱ ↓↓↓

        // CASE1: 삭제할 Node가 Left Node인 경우
        if (currNode.left == null && currNode.right == null) {
            if (value < currNode.value) {
                currParentNode.left = null;
                currNode = null;    //-- 안 적어도 되는데 가독성 위해 적음
            } else {
                currParentNode.right = null;
                currNode = null;
            }
            return true;

        // CASE2-1: 삭제할 Node가 Child Node를 한 개 가지고 있을 경우 (왼쪽에 Child Node 있는 경우)
        } else if (currNode.left != null && currNode.right == null) {
            // currNode가 currParentNode의 왼쪽 자식인 경우
            if (value < currNode.value) {
                currParentNode.left = currNode.left;
                currNode = null;
            // currNode가 currParentNode의 오른쪽 자식인 경우
            } else {
                currParentNode.right = currNode.left;
                currNode = null;
            }
            return true;

        // CASE2-2: 삭제할 Node가 Child Node를 한 개 가지고 있을 경우 (오른쪽에 Child Node 있는 경우)
        } else if (currNode.left == null && currNode.right != null) {
            if (value < currParentNode.value) {
                currParentNode.left = currNode.right;
                currNode = null;
            } else {
                currParentNode.right = currNode.right;
                currNode = null;
            }
            return true;

        // CASE3: 삭제할 Node가 Child Node를 두 개 가지고 있을 때
        // 선택 전략: 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 삭제할 Node의 Parent Node가 가리키도록 한다.
        // --> 그래서 changeNode에 currNode.right 넣어준 것!
        } else {
            // CASE3-1: 삭제할 Node가 부모 Node의 왼쪽에 있을 때
            if (value < currParentNode.value) {
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while (changeNode != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }
                // 여기까지 실행되면, changeNode에는 삭제할 Node의 오른쪽 Node 중에서,
                // 가장 작은 값을 가진 Node가 들어있음

                // CASE3-1-2: changeNode의 오른쪽 Child Node가 있을 때
                if (changeNode.right != null)
                    changeParentNode.left = changeNode.right;
                // CASE3-1-1: changeNode의 Child Node가 없을 때
                else
                    changeParentNode.left = null;

                // currParentNode의 왼쪽 Child Node에,
                // 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 changeNode를 연결
                currParentNode.left = changeNode;

                // parentNode의 왼쪽 Child Node가 현재 changeNode이고,
                // changeNode의 왼쪽/오른쪽 Child Node를 모두
                // 삭제할 currNode의 기존 왼쪽/오른쪽 Node로 변경해줘야 함
                changeNode.left = currNode.left;
                changeNode.right = currNode.right;

                // 작성할 필요는 없지만, 삭제했다는거 보여주기 위해 명시적으로 작성
                currNode = null;

            // CASE3-2: 삭제할 Node가 부모 Node의 오른쪽에 있을 때
            } else {
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while (changeNode != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }
                // 여기까지 실행되면, changeNode에는 삭제할 Node의 오른쪽 Node 중에서,
                // 가장 작은 값을 가진 Node가 들어있음

                // CASE3-1-2: changeNode의 오른쪽 Child Node가 있을 때
                if (changeNode.right != null)
                    changeParentNode.left = changeNode.right;
                // CASE3-1-1: changeNode의 Child Node가 없을 때
                else
                    changeParentNode.left = null;

                // currParentNode의 오른쪽 Child Node에,
                // 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 changeNode를 연결
                currParentNode.right = changeNode;

                // parentNode의 왼쪽 Child Node가 현재 changeNode이고,
                // changeNode의 왼쪽/오른쪽 Child Node를 모두
                // 삭제할 currNode의 기존 왼쪽/오른쪽 Node로 변경해줘야 함
                changeNode.left = currNode.left;
                changeNode.right = currNode.right;

                // 작성할 필요는 없지만, 삭제했다는거 보여주기 위해 명시적으로 작성
                currNode = null;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        T006_tree tr = new T006_tree();
        System.out.println(tr.insertNode(2));
        System.out.println(tr.insertNode(3));
        System.out.println(tr.insertNode(4));
        System.out.println(tr.insertNode(6));
        System.out.println(tr.search(3));   // T006_tree$Node@677327b6
        System.out.println(tr.search(9));   // null
        tr.delete(3);
        System.out.println(tr.search(3));   // null

    }
}
