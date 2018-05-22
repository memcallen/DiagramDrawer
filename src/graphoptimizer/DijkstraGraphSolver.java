/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphoptimizer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Memcallen
 */
public class DijkstraGraphSolver implements GraphSolver {

    private class Node {

        int from = -1;
        double distance = Double.POSITIVE_INFINITY;
        boolean visited = false;
    }

    Map<Integer, Node> nodes = new HashMap<>();

    int start = 0;

    public double DistanceTo(int node) {
        return nodes.get(node).distance;
    }

    public List<Integer> GetPath(int end) {

        LinkedList<Integer> ll = new LinkedList();

        int curr = end;

        if (curr != start) {
            do {
                System.out.println(curr);
                ll.push(curr);
                curr = nodes.get(curr).from;
            } while (curr != start);
        }

        ll.push(start);
        
        return ll;
    }

    public void SetStart(int index) {
        start = index;
    }

    @Override
    public void Process(GraphAL graph) {

        for (int i = 0; i < graph.GetNumVerts(); i++) {
            nodes.put(i, new Node());
        }

        LinkedList<Integer> tbp = new LinkedList<>();

        tbp.push(start);

        nodes.get(start).distance = 0;

        while (tbp.size() > 0) {

            int curr = tbp.poll();
            Node ncurr = nodes.get(curr);

            Double[] conns = GetConnections(graph, curr);

            for (int i = 0; i < conns.length; i++) {
                //if it's a valid connection, process and add to queue
                if (conns[i] != Double.POSITIVE_INFINITY) {

                    Node cnode = nodes.get(i);

                    //if this path's distance is less than the current path,
                    //update the path
                    if (cnode.distance > ncurr.distance + conns[i]) {
                        cnode.from = curr;
                        cnode.distance = ncurr.distance + conns[i];
                    }

                    if (!cnode.visited) {
                        tbp.add(i);
                    }

                }
            }

            ncurr.visited = true;

        }

    }

    private boolean visited(int index) {
        return nodes.get(index).visited;
    }

    private Double[] GetConnections(GraphAL graph, int vertex) {

        Double[] out = new Double[graph.GetNumVerts()];

        for (int i = 0; i < out.length; i++) {
            out[i] = graph.GetDist(vertex, i);
        }

        return out;
    }

}
