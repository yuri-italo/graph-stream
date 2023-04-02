package br.newtonpaiva.algorithms.generators.apparition.algorithm;

import org.graphstream.algorithm.DynamicAlgorithm;
import org.graphstream.graph.Graph;
import org.graphstream.stream.SinkAdapter;

import java.util.HashMap;

/*
    In this example, computation is done continuously in a loop.
    One may want to make the computation when receiving events.
    This can be done with a Sink that will trigger the computation.
    For example, this is a dynamic algorithm where computation is done when a node is added:
*/
public class ApparitionAlgorithm extends SinkAdapter implements DynamicAlgorithm {

    Graph theGraph;
    HashMap<String, Integer> apparitions;
    double avg;

    public void init(Graph graph) {
        theGraph = graph;
        avg = 0;
        apparitions = new HashMap<>();
        graph.addSink(this);
    }

    public void compute() {
        avg = 0;

        for (int a : apparitions.values()) {
            avg += a;
        }
        avg /= apparitions.size();
    }

    public void terminate() {
        theGraph.removeSink(this);
    }

    public double getAverageApparitions() {
        return avg;
    }

    public int getApparitions(String nodeId) {
        return apparitions.get(nodeId);
    }

    public void nodeAdded(String sourceId, long timeId, String nodeId) {
        int a = 0;

        if (apparitions.containsKey(nodeId))
            a = apparitions.get(nodeId);

        apparitions.put(nodeId, a + 1);
    }

    public void stepBegins(String sourceId, long timeId, double step) {
        compute();
    }
}
