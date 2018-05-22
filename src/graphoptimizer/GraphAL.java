/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphoptimizer;

import commonutils.data.Pair;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.joml.Vector2d;

/**
 * Graph Abstraction Layer
 * @author Memcallen
 */
public interface GraphAL {

    public default HashMap<Integer, HashSet<Integer>> GetHashConnections() {

        List<Pair<Integer, Integer>> conns = GetConnections();
        HashMap<Integer, HashSet<Integer>> out = new HashMap<>();

        conns.stream().map((p) -> {
            if (!out.containsKey(p.first())) {
                out.put(p.first(), new HashSet<>());
            }
            return p;
        }).forEachOrdered((p) -> {
            out.get(p.first()).add(p.second());
        });

        return out;
    }

    public List<Pair<Integer, Integer>> GetConnections();

    public double GetDist(int from, int to);

    public double GetMinDist(int from, int to);

    public Vector2d GetPosition(int index);

    public void SetPosition(int index, Vector2d pos);

    public int GetNumVerts();

}
