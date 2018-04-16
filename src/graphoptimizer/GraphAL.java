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
 * Graph Abstraction Layer
 * @author AZ
 */
public interface GraphAL {
    
    public List<Pair<Integer, Integer>> GetConnections();
    
    public double GetDist(int from, int to);

    public double GetMinDist(int from, int to);
    
    public Vector2d GetPosition(int index);
    
    public void SetPosition(int index, Vector2d pos);
    
    public int GetNumVerts();
    
}
