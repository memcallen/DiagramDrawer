/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphoptimizer;

import commonutils.data.Pair;
import java.util.List;
import java.util.Map;
import no.uib.cipr.matrix.Matrix;
import no.uib.cipr.matrix.sparse.LinkedSparseMatrix;

/**
 * TODO add author
 * @author
 */
public class Util {

    public static Pair<Integer, Integer> edge(int a, int b) {
        return new Pair(a < b ? a : b, a > b ? a : b);
    }

    public static void edge(Map<Pair<Integer, Integer>, Double> map, 
            int from, int to, double weight) {
        
        map.put(edge(from, to), weight);
        
    }
    
    public Matrix AdjacencyMatrix(GraphAL graph) {
        
        int n = graph.GetNumVerts();
        LinkedSparseMatrix mat = new LinkedSparseMatrix(n, n);
        
        List<Pair<Integer, Integer>> conns = graph.GetConnections();
        
        conns.stream().map((p) -> {
            mat.add(p.first(), p.second(), 1);
            return p;
        }).forEachOrdered((p) -> {
            mat.add(p.second(), p.first(), 1);
        });
        
        return mat;
    }
    
}
