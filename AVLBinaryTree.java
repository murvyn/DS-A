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
        root.height = 1 + Math.max(height(root.leftChild), height(root.rightChild));

        balance(root);

        
        return root;
    }
    
    private void balance(AVLNode root) {
        if(isLeftHeavy(root)){
            if(balanceFactor(root.leftChild) < 0){
                System.out.println("left rotate" + root.leftChild.value);
            }
            System.out.println("Right rotate" + root.value);
        }
       else if(isRightHeavy(root)){
        if(balanceFactor(root.rightChild) > 0){
            System.out.println("right rotate" + root.rightChild.value);
        }
        System.out.println("left rotate" + root.value);
        }
        
    }

    private int balanceFactor(AVLNode node) {
        return node == null ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private boolean isLeftHeavy (AVLNode node){
        return balanceFactor(node) > 1;
    }
   
    private boolean isRightHeavy (AVLNode node){
        return balanceFactor(node) < -1;
    }

    private int height(AVLNode node) {
        return node == null ? -1 : node.height;
    }
}
