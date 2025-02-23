import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrieExercise {
    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("car");
        // test.add("dog");

        Longest trie = new Longest();

        for(var word : test){
            trie.insert(word);
        }

        System.out.print(trie.longest());
    }
}

class Trie {
    public static int ALPHABET_SIZE = 26;

    private class Node {
        private final char value;
        // private Node[] children = new Node[ALPHABET_SIZE];
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value = " + value;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public void removeChild(char ch) {
            children.remove(ch);
        }
    }

    private Node root = new Node(' ');

    public void insert(String value) {
        var current = root;
        for (var ch : value.toCharArray()) {
            // var index = ch - 'a';
            // if(current.children[index] == null) {
            // current.children[index] = new Node(ch);
            // }
            // current = current.children[index];
            if (current.hasChild(ch)) {
                current.addChild(ch);
            }
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        var current = root;
        for (var ch : word.toCharArray()) {
            if (!current.hasChild(ch)) {
                return false;
            }
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public void remove(String word) {
        remove(root, word, 0);
    }

    private void remove(Node root, String word, int index) {
        if (index == word.length()) {
            root.isEndOfWord = false;
            return;
        }
        var ch = word.charAt(index);
        var child = root.getChild(ch);
        if (child == null) {
            return;
        }

        remove(child, word, index + 1);

        if (!child.hasChildren() && !child.isEndOfWord) {
            root.removeChild(ch);
        }
    }

    public List<String> findWords(String prefix) {
        List<String> words = new ArrayList<>();
        var lastNode = findLastNodeOf(prefix);
        findWords(lastNode, words, prefix);
        return words;
    }

    private void findWords(Node root, List<String> words, String prefix) {
        if (root == null) {
            return;
        }

        if (root.isEndOfWord) {
            words.add(prefix);
        }

        for (var child : root.getChildren()) {
            findWords(child, words, prefix + child.value);
        }
    }

    private Node findLastNodeOf(String prefix) {
        var current = root;
        for (var ch : prefix.toCharArray()) {

            var child = current.getChild(ch);
            if (child == null) {
                return null;
            }
            current = child;
        }
        return current;
    }

    public void preOrderTraverse() {
        preOrderTraverse(root);
    }

    private void preOrderTraverse(Node root) {
        System.out.println(root.value);
        for (var child : root.getChildren()) {
            preOrderTraverse(child);
        }
    }

    public void postOrderTraverse() {
        postOrderTraverse(root);
    }

    private void postOrderTraverse(Node root) {
        for (var child : root.getChildren()) {
            postOrderTraverse(child);
        }
        System.out.println(root.value);
    }
}

class Longest {
    private class Node {
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }
    }

    private Node root = new Node(' ');

    public void insert(String word) {
        var current = root;
        for (var ch : word.toCharArray()) {
            if (current.children.get(ch) == null) {
                current.children.put(ch, new Node(ch));
            }
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
    }
    public String longest() {
        StringBuilder sb = new StringBuilder();
        longest(root, sb);
        return sb.toString();
    }

    private void longest(Node root, StringBuilder sb) {
        sb.append(root.value);

        if(root.getChildren().length > 1 || root.isEndOfWord){
            return;
        }

        for(var child : root.getChildren()) {
            longest(child, sb);
        }
    }
}