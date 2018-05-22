/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphoptimizer;

import commonutils.data.Pointer;
import commonutils.data.Pair;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * @author Memcallen
 */
public class GridAlignedGO implements GraphSolver {

    private double resolution = 1;

    private Map<Pair<Integer, Integer>, Pointer<Integer>> data = new HashMap<>();

    
    
    private List<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> 
                GetIntersections
        (GraphAL graph, List<Integer> last_touched) {

        List<Pair<Integer, Integer>> connections = graph.GetConnections()
                .stream().filter(
                        p -> last_touched.contains(p.first()) || 
                        last_touched.contains(p.second()))
                .collect(Collectors.toList());
        
        List<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> 
                out = new LinkedList<>();
        
        for(int a = 0; a < connections.size(); a++) {
            for(int b = a + 1; b < connections.size(); b++) {
                
            }
        }
        
        return out;
    }

    
    
    @Override
    public void Process(GraphAL graph) {

        
        
    }

}
