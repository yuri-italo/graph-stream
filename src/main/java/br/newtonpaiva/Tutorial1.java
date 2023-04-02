package br.newtonpaiva;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class Tutorial1 {
    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui", "swing");

        Graph graph = new SingleGraph("Tutorial 1");

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("AB","A","B");
        graph.addEdge("BC","B","C");
        graph.addEdge("CA","C","A");

        // creating nodes automatically

//        graph.setStrict(false);
//        graph.setAutoCreate( true );
//        graph.addEdge( "AB", "A", "B" );
//        graph.addEdge( "BC", "B", "C" );
//        graph.addEdge( "CA", "C", "A" );


        Node A = graph.getNode("A");
        Node B = graph.getNode("B");
        Node C = graph.getNode("C");
        System.out.println("Node A id -> " + A.getId());
        System.out.println("Node A degree -> " + A.getDegree());
        System.out.println("Is A connected to B? -> " + A.hasEdgeToward(B));
        System.out.println("Is B connected to C? -> " + B.hasEdgeToward(C));
        System.out.println("Edges connected to A and C -> " + A.getEdgeToward(C));
        System.out.println("Edges connected to B and A -> " + B.getEdgeToward(A));

        System.out.println("----------------------");

        Edge AB = graph.getEdge("AB");
        System.out.println("Edge AB id -> " + AB.getId());
        System.out.println("Edge AB is directed -> " + AB.isDirected());
        System.out.println("Node at the other end of the edge -> " + AB.getOpposite(A));

        System.out.println("----------------------");

        System.out.println("Iterating nodes:");
        for(Node n:graph) {
            System.out.println(n.getId());
        }

        System.out.println("----------------------");

        System.out.println("Iterating edges:");
        graph.edges().forEach(e -> {
            System.out.println(e.getId());
        });

        System.out.println("----------------------");

        System.out.println("Iterating nodes by index:");

        for (int i = 0; i < graph.getNodeCount(); i++) {
            Node node = graph.getNode(i);
            System.out.println(node.getId());
        }

        System.out.println("----------------------");

        System.out.println("The following code constructs the adjacency matrix of a graph:");

        int n = graph.getNodeCount();
        byte[][] adjacencyMatrix = new byte[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                adjacencyMatrix[i][j] = (byte) (graph.getNode(i).hasEdgeBetween(j) ? 1 : 0);

        for (byte[] matrix : adjacencyMatrix) {
            for (byte b : matrix) {
                System.out.print(b + " ");
            }
            System.out.println();
        }

        System.out.println("----------------------");

        System.out.println("Get the index of a node knowing its identifier:");
        int index = graph.getNode("A").getIndex();
        System.out.println(index);

        System.out.println("----------------------");

        System.out.println("Get the identifier of a node when its index is known:");
        String id = graph.getNode(0).getId();
        System.out.println(id);

        graph.display();
    }
}
