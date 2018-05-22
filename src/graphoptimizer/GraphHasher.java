/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphoptimizer;

import commonutils.data.Pair;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author memcallen
 */
public class GraphHasher {

    //this will need to be expanded after testing
    public final static int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23};

    /**
     * Calculates the hash at each node, and returns the largest one
     * @param edges The edges
     * @param types The vertex prime mapping
     * @return The largest hash
     */
    public static Pair<Integer, BigDecimal> GetLargestHash(HashMap<Integer, HashSet<Integer>> edges,
            Map<Integer, Integer> types){
        
        return GetHash(edges, types, (a, b)->a.compareTo(b));
        
    }
    
    /**
     * Calculates the hash at each node, and returns the smallest one
     * @param edges The edges
     * @param types The vertex prime mapping
     * @return The smallest hash
     */
    public static Pair<Integer, BigDecimal> GetSmallestHash(HashMap<Integer, HashSet<Integer>> edges,
            Map<Integer, Integer> types){
        
        return GetHash(edges, types, (a, b)->-a.compareTo(b));
        
    }
    
    /**
     * Calculates the hash at each node, and determines which one to pick from
     * the comparator function.
     * @param edges The edges
     * @param types The vertex prime mapping
     * @param compare The comparator function
     * @return The selected hash
     */
    public static Pair<Integer, BigDecimal> GetHash(HashMap<Integer, HashSet<Integer>> edges,
            Map<Integer, Integer> types, Comparator<BigDecimal> compare){
        
        int cvert = 0;
        BigDecimal chash = null;
        
        for(Integer vert : edges.keySet()) {
            BigDecimal hash = GetHash(edges, types, vert, null);
            
            if(chash == null) {
                chash = hash;
                cvert = vert;
                continue;
            }
            
            if(compare.compare(hash, chash) > 0) {
                chash = hash;
                cvert = vert;
            }
        }
        
        return new Pair<>(cvert, chash);
        
    }
    
    /**
     * This will have issues with stackoverflows for larger graphs.<br>
     * Recursively calculates the prime-factor hash for a graph. Each vertex is
     * assigned a prime number, and the vertices are multiplied via a recursive
     * depth-first algorithm. In the case of a loop, already visited vertices
     * are assigned their prime to the caller, but properly calculate their hash
     * once the recursed calls evaluate.
     * @param edges The edges
     * @param types The vertex prime mapping
     * @param vert The starting vertex
     * @param visited The visited vertices
     * @return The hash
     */
    public static BigDecimal GetHash(HashMap<Integer, HashSet<Integer>> edges,
             Map<Integer, Integer> types, int vert,
            HashMap<Integer, Boolean> visited) {

        //this vertex's prime
        BigDecimal curr = new BigDecimal(PRIMES[types.getOrDefault(vert, 0)]);

        //first call case
        if(visited == null){
            visited = new HashMap<>();
        }
        
        //the vertex must have connections, or atleast a non-null set
        Objects.requireNonNull(edges.get(vert), "Found null set for vertex "
                + vert + " when calculating hash");

        //if this vert hasn't been visited, mark visited and recurse 
        if (Objects.equals(visited.getOrDefault(vert, Boolean.FALSE), Boolean.FALSE)) {

            visited.put(vert, Boolean.TRUE);
            
            //recursively call the hash function for each child, and multiply
            //the products together with this vertex's prime
            for (Integer child : edges.get(vert)) {
                curr = curr.multiply(GetHash(edges, types, child, visited));
            }
        }

        return curr;
    }

}
