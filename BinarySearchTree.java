
public class BinarySearchTree {
    public static void main (String[] args) {

    }
}

class Tree {
    private class Node {
        private int value;
        private Node leftChild, rightChild;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void insert(int value) {
        if(root == null) {
            root = new Node(value);
        }
        Node currentNode = root;
        
    }

}
