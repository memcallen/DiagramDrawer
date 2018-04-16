/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphoptimizer;

import commonutils.data.Pair;
import static graphoptimizer.Util.*;
import java.util.HashMap;

/**
 *
 * @author azalac0020
 */
public class GraphOptimizer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        HashMap<Pair<Integer, Integer>, Double> edges = new HashMap<>();
        
        edge(edges, 0, 1, 1);
        edge(edges, 0, 2, 2);
        
        edge(edges, 1, 2, 3);
        edge(edges, 1, 4, 3);
        
        edge(edges, 2, 3, 3);
        edge(edges, 2, 4, 2);
        edge(edges, 2, 5, 2);
        
        edge(edges, 3, 5, 1);
        edge(edges, 3, 6, 3);
        
        edge(edges, 4, 5, 1);
        
        edge(edges, 5, 6, 2);
        
        StdGraphAL gal = new StdGraphAL(edges, 7);
        
        DijkstraGraphSolver dgs = new DijkstraGraphSolver();
        
        dgs.SetStart(0);
        
        dgs.Process(gal);
        
        System.out.println(dgs.GetPath(0) + ":" + dgs.DistanceTo(0));
    }
    
}
