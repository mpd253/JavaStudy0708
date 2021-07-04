import java.util.*;

class Node {
    private int value;
    private Node left;
    private Node right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
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
        if (root == null) {
            Node node = new Node();
            node.setValue(value);
            root = node;
        } else {
            addNode(value, root);
        }
    }

    public void addNode(int value, Node root) {
        if (value < root.getValue()) {
            if (root.getLeft() == null) {
                Node node = new Node();
                node.setValue(value);
                root.setLeft(node);
            } else {
                addNode(value, root.getLeft());
            }
        } else if (value > root.getValue()) {
            if (root.getRight() == null) {
                Node node = new Node();
                node.setValue(value);
                root.setRight(node);
            } else {
                addNode(value, root.getRight());
            }
        }
    }

    public void postorder(Node root) {						// left -> right -> root(부모 노드)
        if (root != null) {
            postorder(root.getLeft());
            postorder(root.getRight());
            System.out.println(root.getValue());
        }
    }
    
    public void printTree() {
        postorder(root);
    }
}
public class BinarySearchTree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string;
        Tree tree = new Tree();

        while (scanner.hasNextLine() && !(string = scanner.nextLine()).equals("")) {
            tree.addNode(Integer.parseInt(string));
        }

        tree.printTree();

    }
}