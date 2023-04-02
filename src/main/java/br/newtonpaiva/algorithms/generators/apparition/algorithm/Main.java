package br.newtonpaiva.algorithms.generators.apparition.algorithm;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class Main {
    public static void main(String[] args) {
        // Set the GraphStream UI to use the Swing interface
        System.setProperty("org.graphstream.ui", "swing");

        // Create a new graph
        Graph graph = new SingleGraph("Apparition Algorithm");

        // Create nodes
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");

        // Create edges
        graph.addEdge("AB", "A", "B");
        graph.addEdge("BC", "B", "C");
        graph.addEdge("CA", "C", "A");
        graph.addEdge("AD", "A", "D");
        graph.addEdge("DE", "D", "E");
        graph.addEdge("EC", "E", "C");

        // Create an instance of the ApparitionAlgorithm
        ApparitionAlgorithm algorithm = new ApparitionAlgorithm();

        // Initialize the algorithm with the graph
        algorithm.init(graph);

        // Run the algorithm for each node in the graph
        for (Node node : graph) {
            algorithm.compute();
        }

        // Terminate the algorithm
        algorithm.terminate();

        // Print the number of times node A appears in the graph
        System.out.println("Node A appears " + algorithm.getApparitions("A") + " times in the graph.");
    }
}

