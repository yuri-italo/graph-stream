package br.newtonpaiva.algorithms.generators.degrees.algorithm;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class Main {
    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui", "swing");

        // Creation of the graph
        Graph graph = new SingleGraph("Degrees Algorithm");

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("AB","A","B");
        graph.addEdge("BC","B","C");
        graph.addEdge("CA","C","A");
        graph.addEdge("AD","A","D");

        var algorithm = new DegreesAlgorithm() ; // My algorithm
        algorithm.init(graph);
        algorithm.compute();

        System.out.println("Max degree -> " + algorithm.getMaxDegree());
        System.out.println("Min degree -> " + algorithm.getMinDegree());
        System.out.println("Avg degree -> " + algorithm.getAverageDegree());

        graph.display();
    }
}
