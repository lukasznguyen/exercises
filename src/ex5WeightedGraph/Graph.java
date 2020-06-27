package ex5WeightedGraph;

import java.util.*;

public class Graph {

    List<Node> nodes;
    List<Edge> edges;

    public Graph() {
        nodes = createNodes();
        edges = createEdges(nodes);
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

//        Nodes
//        for(Node n : graph.nodes){
//            System.out.println(n);
//        }
//        Edges
//        for (Edge e : graph.edges) {
//            System.out.println(e);
//        }

        int result = graph.getMinPath(graph.nodes.get(0), graph.nodes.get(2));
        System.out.println("Shortest path from node 'A' to node 'C': \t"+result);
        int result2 = graph.getMinPath(graph.nodes.get(0), graph.nodes.get(3));
        System.out.println("Shortest path from node 'A' to node 'D': \t"+result2);
    }

    public static List<Node> createNodes() {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            nodes.add(new Node((char) (65 + i)));
        }
        return nodes;
    }

    public static List<Edge> createEdges(List<Node> nodes) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(nodes.get(0), nodes.get(1), 1));
        edges.add(new Edge(nodes.get(0), nodes.get(2), 3));
        edges.add(new Edge(nodes.get(0), nodes.get(3), 4));
        edges.add(new Edge(nodes.get(1), nodes.get(2), 1));
        edges.add(new Edge(nodes.get(2), nodes.get(3), 1));
        edges.add(new Edge(nodes.get(1), nodes.get(4), 10));
        edges.add(new Edge(nodes.get(3), nodes.get(4), 4));
        edges.add(new Edge(nodes.get(4), nodes.get(5), 1));
        edges.add(new Edge(nodes.get(1), nodes.get(5), 4));
        return edges;
    }

    public int getMinPath(Node source, Node dest) {
        Map<Node, Integer> minDist = new HashMap<>();

        for (Node node : nodes) {
            minDist.put(node, Integer.MAX_VALUE);
        }

        minDist.replace(source, 0);

        Map<Node, Boolean> visited = new HashMap<>();

        while (true) {
            Node minNode = null;
            for (Node node : minDist.keySet()) {
                if (!visited.containsKey(node)) {
                    if (minNode == null) {
                        minNode = node;
                    }
                    if (minDist.get(node) < minDist.get(minNode)) {
                        minNode = node;
                    }
                }
            }

            if (minNode == null){
                return -1;
            }

            if (minNode == dest) {
                return minDist.get(dest);
            }

            visited.put(minNode, true);

            for (Edge edge : edges) {
                if (edge.node1 == minNode && minDist.get(edge.node2)>minDist.get(minNode)+edge.weight) {
                    minDist.replace(edge.node2, minDist.get(minNode)+edge.weight);
                }
                if (edge.node2 == minNode && minDist.get(edge.node1)>minDist.get(minNode)+edge.weight) {
                    minDist.replace(edge.node1, minDist.get(minNode)+edge.weight);
                }
            }
        }
    }
}

