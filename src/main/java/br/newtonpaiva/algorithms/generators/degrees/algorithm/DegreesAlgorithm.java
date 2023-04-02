package br.newtonpaiva.algorithms.generators.degrees.algorithm;

import org.graphstream.graph.Graph;
import org.graphstream.algorithm.Algorithm;
/*
 The following is an example of a basic algorithm that computes min, max and average degree in the graph:
*/
public class DegreesAlgorithm implements Algorithm {
    Graph theGraph;
    int minDegree, maxDegree, avgDegree;

    public void init(Graph graph) {
        theGraph = graph;
    }

    public void compute() {
        avgDegree = 0;
        minDegree = Integer.MAX_VALUE;
        maxDegree = 0;

        theGraph.nodes().forEach( n -> {
            int deg = n.getDegree();

            minDegree = Math.min(minDegree, deg);
            maxDegree = Math.max(maxDegree, deg);
            avgDegree += deg;
        });

        avgDegree /= theGraph.getNodeCount();
    }

    public int getMaxDegree() {
        return maxDegree;
    }

    public int getMinDegree() {
        return minDegree;
    }

    public int getAverageDegree() {
        return avgDegree;
    }
}
