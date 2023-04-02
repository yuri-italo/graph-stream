package br.newtonpaiva.algorithms.generators.my.full.generator;

import org.graphstream.algorithm.generator.Generator;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class Main {
    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui", "swing");

        Generator generator = new MyFullGenerator();
        Graph graph = new SingleGraph("My Full Generator Example");

        generator.addSink(graph);

        generator.begin();
        for(int i = 0; i < 9; i++)
            generator.nextEvents();
        generator.end();

        graph.display();
    }
}
