
public class BinarySearchTree {
    public static void main (String[] args) {
        Tree tree = new Tree();
        tree.insert(5);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(18);

        tree.traversePreOrder();
        tree.traverseInOrder();
        tree.traversePostOrder();

        System.out.println(tree.find(10));
    }
}

class Tree {
    private class Node {
        private int value;
        private Node leftChild, rightChild;

        public Node(int value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return "Node=" + value;
        }
    }


    private Node root;

    public boolean find(int value) {
        var current = root;
        while(current != null) {
            if(value == current.value) return true;
            else if(value < current.value) {
                current = current.leftChild;
            }else if(value > current.value) {
                current = current.rightChild;
            }
        }
        return false;
    }

    public void insert(int value) {
        Node node = new Node(value);
        if(root == null) {
            root = node;
            return;
        }
        var current = root;
        while (true) { 
            if(value < current.value) {
                if(current.leftChild == null){
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
            else {
                if(current.rightChild == null){
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }}
       
    public void traversePreOrder () {
        traversePreOrder(root);
    }

    private void traversePreOrder (Node root) {
        if(root == null) return;
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }
    
    public void traverseInOrder () {
        traverseInOrder(root);
    }

    private void traverseInOrder (Node root) {
        if(root == null) return;
        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }
    
    public void traversePostOrder () {
        traversePostOrder(root);
    }

    private void traversePostOrder (Node root) {
        if(root == null) return;
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }
    }
