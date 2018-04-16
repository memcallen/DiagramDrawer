/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphoptimizer;

import commonutils.data.Pair;
import java.util.Map;

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
    
}
