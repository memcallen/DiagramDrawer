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
import java.util.Map;
import no.uib.cipr.matrix.Matrix;
import no.uib.cipr.matrix.sparse.LinkedSparseMatrix;

/**
 *
 * @author Memcallen
 */
public class Util {

    public static Pair<Integer, Integer> edge(int a, int b) {
        return new Pair(a < b ? a : b, a > b ? a : b);
    }

    public static void edge(Map<Pair<Integer, Integer>, Double> map,
            int from, int to, double weight) {

        map.put(edge(from, to), weight);

    }

    /**
     * Format (all vertex integers):<br>
     * {@code From=[To, To, To...]}
     *
     * @param edges The graph edges
     * @param format The input string
     *
     */
    public static void edge(HashMap<Integer, HashSet<Integer>> edges,
            String format) {

        String[] halves = format.trim().split("=");

        int from = Integer.parseInt(halves[0].trim());

        HashSet<Integer> set = edges.get(from);

        if (set == null) {
            edges.put(from, set = new HashSet<>());
        }

        halves[1] = halves[1].trim();
        String[] tos = halves[1].substring(1, halves[1].length() - 1).split(",");

        for (String to1 : tos) {
            set.add(Integer.parseInt(to1.trim()));
        }

    }

    /**
     * Format:<br>
     * [V#, V#, V#...]=Type#
     *
     * @param types The types map
     * @param format The format string
     */
    public static void types(Map<Integer, Integer> types, String format) {

        String[] halves = format.trim().split("=");

        String[] ints = halves[0].substring(1, halves[0].length() - 1).split(",");

        int type = Integer.parseInt(halves[1].trim());

        for (String i : ints) {
            types.put(Integer.parseInt(i.trim()), type);
        }
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
