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
public class Pointer<T> {

    protected T t;
    
    public Pointer(T t) {
        this.t = t;
    }
    
    public T Get() {
        return t;
    }
    
    public void Set(T t) {
        this.t = t;
    }
    
    public void swap(Pointer<T> other) {
        T temp = Get();
        Set(other.Get());
        other.Set(temp);
    }
    
}
