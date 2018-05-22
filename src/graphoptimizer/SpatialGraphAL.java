/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphoptimizer;

import commonutils.data.Pair;
import java.util.List;
import org.joml.Vector2d;

/**
 *
 * @author Memcallen
 */
public class SpatialGraphAL implements GraphAL{

    private Vector2d[] positions;
    private List<Pair<Integer, Integer>> conns;
    private Double[] radii;
    
    public SpatialGraphAL(List<Pair<Integer, Integer>> connections, Double[] radii, Vector2d[] positions) {
        this.conns = connections;
        this.radii = radii;
        this.positions = positions;
    }
    
    @Override
    public double GetDist(int from, int to) {
        return positions[from].distance(positions[to]);
    }

    @Override
    public double GetMinDist(int from, int to) {
        return radii[from] + radii[to];
    }

    @Override
    public Vector2d GetPosition(int index) {
        return positions[index];
    }

    @Override
    public void SetPosition(int index, Vector2d pos) {
        positions[index].set(pos);
    }

    @Override
    public int GetNumVerts() {
        return positions.length;
    }

    @Override
    public List<Pair<Integer, Integer>> GetConnections() {
        return conns;
    }

}
