/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphoptimizer;

import commonutils.data.Pair;
import java.util.List;
import no.uib.cipr.matrix.DenseVector;
import no.uib.cipr.matrix.Vector;


/**
 * from
 * https://www.sciencedirect.com/science/article/pii/S089812210500204X?via%3Dihub
 * page 14
 */
public class SpectralGraphOptimizer implements GraphSolver{

    private int p = 2;
    
    private double Energy(GraphAL graph) {
        
        List<Pair<Integer, Integer>> conns = graph.GetConnections();
        
        Vector numerator = new DenseVector(p);
        
        for(Pair<Integer, Integer> _p : conns) {
            numerator.add(new DenseVector(new double[]{}));
        }
        
        return 0;
        
    }
    
    @Override
    public void Process(GraphAL graph) {
        
    }

}
