/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphoptimizer;

import commonutils.data.Pair;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import org.joml.Vector2d;

/**
 *
 * @author Memcallen
 */
public class HashGraphAL implements GraphAL{

    HashMap<Integer, HashSet<Integer>> edges;
    
    public HashGraphAL(HashMap<Integer, HashSet<Integer>> edges) {
        this.edges = edges;
    }
    
    @Override
    public HashMap<Integer, HashSet<Integer>> GetHashConnections() {
        return edges;
    }

    @Override
    public List<Pair<Integer, Integer>> GetConnections() {
        
        List<Pair<Integer, Integer>> out = new LinkedList<>();
        
        edges.entrySet().forEach((e) -> {
            e.getValue().forEach((other) -> {
                out.add(new Pair<>(e.getKey(), other));
            });
        });
        
        return out;
    }

    @Override
    public double GetDist(int from, int to) {
        return 1;
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
        return edges.size();
    }
    
}
