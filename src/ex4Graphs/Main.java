package ex4Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        List<Node> nodes = createNodes();
        Hashtable<Node, List<Node>> data = createGraph(nodes);
        System.out.println(data);
        Graph graph = new Graph(data);
        System.out.print("BFS: ");
        graph.bfs(nodes.get(7));          // starting from node 7
        System.out.print("DFS: ");
        graph.dfs(nodes.get(7));
        System.out.print("Path from 5 to 2: ");
        graph.route(nodes.get(5), nodes.get(2));


    }

    public static List<Node> createNodes(){
        List<Node> nodes = new ArrayList<>();
        for(int i=0; i<8; i++){
            nodes.add(new Node(i));
        }
        return nodes;
    }

    public static Hashtable<Node, List<Node>> createGraph(List<Node> nodes){
        Hashtable<Node, List<Node>> data = new Hashtable<>();
        data.put(nodes.get(0), Arrays.asList(nodes.get(1), nodes.get(2), nodes.get(3), nodes.get(4)));
        data.put(nodes.get(1), Arrays.asList(nodes.get(0), nodes.get(3), nodes.get(4), nodes.get(5) ));
        data.put(nodes.get(2), Arrays.asList(nodes.get(0), nodes.get(3), nodes.get(6)));
        data.put(nodes.get(3), Arrays.asList(nodes.get(0), nodes.get(1), nodes.get(2), nodes.get(4), nodes.get(6), nodes.get(7)));
        data.put(nodes.get(4), Arrays.asList(nodes.get(0), nodes.get(1), nodes.get(3), nodes.get(5), nodes.get(6), nodes.get(7) ));
        data.put(nodes.get(5), Arrays.asList(nodes.get(1), nodes.get(4), nodes.get(7)));
        data.put(nodes.get(6), Arrays.asList(nodes.get(2), nodes.get(3), nodes.get(4), nodes.get(7) ));
        data.put(nodes.get(7), Arrays.asList(nodes.get(3), nodes.get(4), nodes.get(5), nodes.get(6) ));
        return data;
    }
}
