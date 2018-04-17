/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commonutils.data;

import java.util.Objects;

/**
 * TODO add author
 * @author
 */
public class Pair<S, T> {

    S s;
    T t;

    public Pair(S s, T t) {
        this.s = s;
        this.t = t;
    }

    @Override
    public boolean equals(Object other) {
        return this.hashCode() == other.hashCode() && other instanceof Pair;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.s);
        hash = 71 * hash + Objects.hashCode(this.t);
        return hash;
    }

    public S first() {
        return s;
    }
    
    public T second() {
        return t;
    }
    
}
