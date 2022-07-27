import java.util.ArrayList;

public class BinarySearchTree {

    public Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int data) {

        // 인서트될 노드
        Node newNode = new Node(data);

        if(root == null){ // 루트가 비어있으면
            root = newNode;
            return;
        }

        if(root.getData() == data){ // 중복일때 정지
            return;
        }

        Node currentNode = root;
        Node parentNode = null;

        while(true){
            parentNode = currentNode;
            if(data < currentNode.getData()){
                // 입력된 데이터가 현재 노드의 데이터보다 작으면
                if (currentNode == null) {
                    parentNode.setLeft(newNode);
                    return;
                }
                else if(currentNode.getData() == newNode.getData()){
                    // 현재 노드와 입력 노드의 값이 같을 경우
                    return;
                }
                else{
                    // 입력된 데이터가 현재 노드 데이터보다 클 때
                    currentNode = newNode.getRight();
                    if(currentNode == null){
                        // 현재노드가 비어있으면 부모 노드의 오른쪽 자식노드
                        parentNode.setRight(newNode);
                        return;
                    } else if (currentNode.getData() == newNode.getData()) {
                        return;
                    }
                }
            }
        }
    }

    public boolean contains(int data) {
        // 같은 값이 있으면 트루가 됨
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.getData() == data) {
                return true;
            }
            if (currentNode.getData() > data) {
                currentNode = root.getLeft();
            }
            if (currentNode.getData() < data) {
                currentNode = root.getRight();
            }
        }
        return false;
    }

    // 전위 순회 : 중간 - 왼 - 오
    public ArrayList<Integer> preOrder(Node root, int depth, ArrayList<Integer> list) {
        if(root != null){
            list.add(root.getData());
            preOrder(root.getLeft(), depth + 1, list);
            preOrder(root.getRight(), depth + 1, list);
        }
        return list;
    }

    public ArrayList<Integer> inOrder(Node root, int depth, ArrayList<Integer> list) {
        if (root != null) {
            inOrder(root.getLeft(), depth + 1, list);
            list.add(root.getData());
            inOrder(root.getRight(), depth + 1, list);
        }
        return list;
    }

    public ArrayList<Integer> postOrder(Node root, int depth, ArrayList<Integer> list) {
        if (root != null) {
            postOrder(root.getLeft(), depth + 1, list);
            preOrder(root.getRight(), depth + 1, list);
            list.add(root.getData());
        }
        return list;
    }
}
