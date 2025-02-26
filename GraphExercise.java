
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class GraphExercise {
    public static void main(String[] args) {

    }
}

class Graph {
    private class Node {
        
        private final String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }
    private final Map<String, Node> nodes = new HashMap<>();
    private final Map<Node, List<Node>> adjacentNodes = new HashMap<>();

    public void addNode(String label) {
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacentNodes.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        var fromNode = nodes.get(from);
        if (fromNode == null) {
            throw new IllegalArgumentException();
        }

        var toNode = nodes.get(from);
        if (toNode == null) {
            throw new IllegalArgumentException();
        }

        adjacentNodes.get(fromNode).add(toNode);
    }

    public void removeNode(String label) {
        var node = nodes.get(label);
        if (node == null) {
            return;
        }
        for (var n : adjacentNodes.keySet()) {
            adjacentNodes.get(n).remove(node);
        }
        adjacentNodes.remove(node);
        nodes.remove(node);
    }

    public void removeEdge(String from, String to) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        if (fromNode == null || toNode == null) {
            return;
        }

        adjacentNodes.get(fromNode).remove(toNode);
    }

    public void traverseDepthFirst(String root) {
        var node = nodes.get(root);
        if (node == null) {
            return;
        }
        traverseDepthFirst(node, new HashSet<>());
    }

    public void traverseDepthFirstIteration(String root) {
        var node = nodes.get(root);
        if (node == null) {
            return;
        }

        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            var current = stack.pop();

            if (visited.contains(current)) {
                continue;
            }

            System.out.println(current);
            visited.add(current);

            for (var neighbors : adjacentNodes.get(current)) {
                if (!visited.contains(neighbors)) {
                    stack.push(neighbors);
                }
            }
        }
    }

    private void traverseDepthFirst(Node root, Set<Node> visited) {
        System.out.println(root);
        visited.add(root);

        for (var node : adjacentNodes.get(root)) {
            if (!visited.contains(node)) {
                traverseDepthFirst(node, visited);
            }
        }
    }

    public void traverseBreadthFirst(String root) {
        var node = nodes.get(root);
        if (node == null) {
            return;
        }

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(node);

        while (!queue.isEmpty()) {
            var current = queue.remove();

            if (visited.contains(current)) {
                continue;
            }
            System.out.println(current);
            visited.add(current);

            for (var neighbors : adjacentNodes.get(current)) {
                if (!visited.contains(neighbors)) {
                    queue.add(neighbors);
                }
            }
        }
    }

    public List<String> topologicalSort() {
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        for (var node : nodes.values()) {
            topologicalSort(node, stack, visited);
        }

        List<String> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop().label);
        }
        return result;
    }

    private void topologicalSort(Node node, Stack<Node> stack, Set<Node> visited) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);

        for (var neighbors : adjacentNodes.get(node)) {
            topologicalSort(neighbors, stack, visited);
        }

        stack.push(node);
    }

    public boolean hasCycle () {
        Set<Node> all = new HashSet<>();
        all.addAll(nodes.values());
        Set<Node> visited = new HashSet<>();
        Set<Node> visiting = new HashSet<>();

        while(!all.isEmpty()) {
            var node = all.iterator().next();
            if(hasCycle(node, all,visiting, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycle( Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited ) {
        all.remove(node);
        visiting.add(node);

        for(var neighbors : adjacentNodes.get(node)) {
            if(visiting.contains(node)){
                return true;
            }
            if(hasCycle(neighbors, all, visiting, visited)) {
                return true;
            }
        }
        visiting.remove(node);
        visited.add(node);
        return false;
    }
    
    public void print() {
        for (var source : adjacentNodes.keySet()) {
            var targets = adjacentNodes.get(source);
            if (!targets.isEmpty()) {
                System.out.print(source + " is connected to " + targets);
            }
        }
    }
}