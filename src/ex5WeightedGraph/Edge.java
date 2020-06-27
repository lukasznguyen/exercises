package ex5WeightedGraph;

public class Edge {

    Node node1;
    Node node2;
    int weight;

    public Edge(Node node1, Node node2, int weight){
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    public String toString(){
        return node1+", "+node2+"\t"+weight;
    }
}
