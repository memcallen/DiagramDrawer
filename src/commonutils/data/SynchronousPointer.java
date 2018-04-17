/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commonutils.data;

/**
 * TODO add author
 * @author
 */
public class SynchronousPointer<T> extends Pointer<T>{

    private final Object lock = new Object();
    
    public SynchronousPointer(T t) {
        super(t);
    }

    @Override
    public T Get() {
        synchronized(lock) {
            return t;
        }
    }
    
    @Override
    public void Set(T t) {
        synchronized(lock) {
            this.t = t;
        }
    }
    
}
