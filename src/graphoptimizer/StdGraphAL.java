/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphoptimizer;

import commonutils.data.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.joml.Vector2d;

/**
 * Basic GAL implementation, no spatial information
 * Minimum for Djikstra's algorithm
 * @author Memcallen
 */
public class StdGraphAL implements GraphAL{

    Map<Pair<Integer, Integer>, Double> edges;
    int num_verts = 0;
    
    /**
     * MUST HAVE SEQUENCIAL VERTEX NUMBERS
     * @param edges the edges
     * @param num_verts the number of vertices
     */
    public StdGraphAL(Map<Pair<Integer, Integer>, Double> edges, int num_verts) {
        this.edges = edges;
        this.num_verts = num_verts;
    }
    
    @Override
    public double GetDist(int from, int to) {
        return from == to ? 0 :
                edges.getOrDefault(Util.edge(from, to), Double.POSITIVE_INFINITY);
    }

    @Override
    public double GetMinDist(int from, int to) {
        return 0;
    }

    @Override
    public Vector2d GetPosition(int index) {
        return null;
    }

    @Override
    public void SetPosition(int index, Vector2d pos) {
        
    }

    @Override
    public int GetNumVerts() {
        return num_verts;
    }

    @Override
    public List<Pair<Integer, Integer>> GetConnections() {
        List<Pair<Integer, Integer>> out = new ArrayList<>();
        
        out.addAll(edges.keySet());
        
        return out;
    }

}
