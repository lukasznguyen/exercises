package ex4Graphs;

import java.util.*;

public class Graph {

    Hashtable<Node, List<Node>> data;

    public Graph(Hashtable<Node, List<Node>> data){
        this.data = data;
    }

    public void bfs(Node start){
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Boolean> visited = new HashMap<>();
        queue.add(start);
        visited.put(start, true);
        StringBuilder output = new StringBuilder(start.toString());
        do {
            Node key = queue.remove();
            for (Node node : data.get(key) ) {
                if(!visited.containsKey(node)){
                    queue.add(node);
                    visited.put(node, true);
                    output.append(" ").append(node);
                }
            }

        } while(!queue.isEmpty());
        System.out.println(output);
    }

    public void dfs(Node start){
        Map<Node, Boolean> visited = new HashMap<>();
        visited.put(start, true);
        System.out.print(start+" ");
        dfshelper(start, visited);
        System.out.println();

    }

    public void dfshelper(Node node, Map<Node, Boolean> visited){
        for (Node nextNode : data.get(node) ) {
            if(!visited.containsKey(nextNode)){
                visited.put(nextNode, true);
                System.out.print(nextNode+" ");
                dfshelper(nextNode, visited);
            }
        }
    }

    public void route(Node start, Node finish){
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Boolean> visited = new HashMap<>();
        Map<Node, Node> previous = new HashMap<>();
        visited.put(start, true);
        queue.add(start);

        while (!queue.isEmpty() && !visited.containsKey(finish) ) {
            Node node = queue.remove();
            for (Node nextNode : data.get(node)) {
                if (!visited.containsKey(nextNode))  {
                    visited.put(nextNode, true);
                    previous.put(nextNode, node);
                    queue.add(nextNode);
                }
            }
        }

        StringBuilder output = new StringBuilder();
        Node node = finish;
        while (node != start) {
            output.append(node).append(" ");
            node = previous.get(node);
        }
        output.append(start);
        output = new StringBuilder(reverse(output.toString()));
        System.out.println(output);
    }

    public static String reverse(String str){
        String reversed = "";
        for(int i=str.length()-1; i>=0; i--){
            reversed += str.charAt(i);
        }
        return reversed;
    }

}
