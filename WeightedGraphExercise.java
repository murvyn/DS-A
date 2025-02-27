import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraphExercise {
    public static void main(String[] args) {
        var graph = new WeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "C", 2);
        graph.print();
    }
}


class WeightedGraph {
    private class Node {
        private final String label;
        private List<Edge> edges = new ArrayList<>();
        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }

        public void addEdge(Node to, int weight) {
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges() {
            return edges;
        }
    }

    private class Edge {
        private final Node from;
        private final Node to;
        private final int weight;

        public Edge(Node to, Node from, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + " -> " + to ;
        }
    }

    private final Map<String, Node> nodes = new HashMap<>();

    public void addNode (String label) {
        nodes.putIfAbsent(label, new Node(label));
    }

    public void addEdge (String from, String to, int weight ) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if (fromNode == null || toNode == null) {
            throw new IllegalArgumentException();
        }

        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }

    public void print() {
        for (var node : nodes.values()) {
            var edges = node.getEdges();
            if(!edges.isEmpty()) {
                System.out.println(node + "is connected to " + edges);
            }
        }
    }

}