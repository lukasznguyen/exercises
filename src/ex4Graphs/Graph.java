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


    public void routedfs(Node start, Node end){
        Map<Node, Boolean> visited = new HashMap<>();
        List<Node> path = new ArrayList<>();
        visited.put(start, true);
        path.add(start);
        dfshelper2(start, end, visited, path);
    }

    public boolean dfshelper2(Node current, Node end, Map<Node, Boolean> visited, List<Node> path){
        for (Node nextNode : data.get(current) ) {
            if(!visited.containsKey(nextNode)){
                visited.put(nextNode, true);
                path.add(nextNode);

                if (nextNode == end){
                    for (Node node : path) {
                        System.out.print(node+" ");
                    }
                    return true;
                }

                if (dfshelper2(nextNode, end, visited, path)) {
                    return true;
                }
                path.remove(nextNode);
            }
        }
        return false;
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

        printPath(finish, previous, start);
    }

    private void printPath(Node end, Map<Node, Node> previous, Node start) {
        List<Node> path = new ArrayList<>();
        Node node = end;
        while (node != start) {
            path.add(node);
            node = previous.get(node);
        }
        StringBuilder output = new StringBuilder();
        output.append(" ").append(start);
        for (int i = path.size() - 1; i >= 0; i--) {
            output.append(" ").append(path.get(i).toString());
        }

        System.out.println(output);
    }
}
