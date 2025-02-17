public class AVLBinaryTree {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
    }
}

class AVLTree {
    private class AVLNode {
        private int value;
        private AVLNode leftChild, rightChild;
        private int height;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Value = " + value;
        }
    }

    private AVLNode root;

    public void insert(int value) {
        root = insert(value, root);
    }

    private AVLNode insert(int value, AVLNode root) {
        if (root == null) {
            return new AVLNode(value);
        }
        if (value < root.value) {
            root.leftChild = insert(value, root.leftChild);
        } else {
            root.rightChild = insert(value, root.rightChild);
        }
        setHeight(root);
        return balance(root);
    }

    private AVLNode balance(AVLNode root) {
        if (isLeftHeavy(root)) {
            if (balanceFactor(root.leftChild) < 0) {
                root.leftChild = rotateLeft(root.leftChild);
            }
          return rotateRight(root.rightChild);
        } else if (isRightHeavy(root)) {
            if (balanceFactor(root.rightChild) > 0) {
                root.rightChild = rotateRight(root.rightChild);
            }
            return rotateLeft(root.leftChild);
        }
        return root;
    }

    private AVLNode rotateLeft(AVLNode root) {
        var newRoot = root;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;
        setHeight(newRoot);
        setHeight(root);
        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root) {
        var newRoot = root;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        setHeight(newRoot);
        setHeight(root);

        return newRoot;
    }

    public void setHeight(AVLNode root) {
        root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;
    }

    private int balanceFactor(AVLNode node) {
        return node == null ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private int height(AVLNode node) {
        return node == null ? -1 : node.height;
    }
}
