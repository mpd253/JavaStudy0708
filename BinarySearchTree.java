import java.util.*;

class Node {
    private int value;
    private Node left;
    private Node right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {				// 집어넣는 값 value = int형
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

class Tree {
    public Node root;

    public void addNode(int value) {
        if (root == null) {							// 부모 노드가 비어 있는 경우
            Node node = new Node();
            node.setValue(value);
            root = node;
        } else {									// 부모 노드가 있는 경우
            addNode(value, root);
        }
    }

    public void addNode(int value, Node root) {
        if (value < root.getValue()) {				// 집어넣는 값이 부모 노드보다 작을 경우
            if (root.getLeft() == null) {			
                Node node = new Node();
                node.setValue(value);
                root.setLeft(node);
            } else {
                addNode(value, root.getLeft());
            }
        } else if (value > root.getValue()) {		// 집어넣는 값이 부모 노드보다 클 경우
            if (root.getRight() == null) {
                Node node = new Node();
                node.setValue(value);
                root.setRight(node);
            } else {
                addNode(value, root.getRight());
            }
        }
    }

    public void postorder(Node root) {				// left -> right -> root(부모 노드)
        if (root != null) {
            postorder(root.getLeft());
            postorder(root.getRight());
            System.out.println(root.getValue());
        }
    }
    
    public void printTree() {						// 출력을 도와줌
        postorder(root);
    }
}

public class BinarySearchTree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string;
        Tree tree = new Tree();

        while (scanner.hasNextLine() && !(string = scanner.nextLine()).equals("")) {
       // 다음 라인에 아무것도 없을때까지 반복문 돔
            tree.addNode(Integer.parseInt(string));
        }

        tree.printTree();

    }
}