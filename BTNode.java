/*Tumulak, Rachel Monique K.
 *CS203
 *2CSA
 *Lab Exercise 9
 */

public class BTNode<T> {
    int level;
    T key;
    BTNode<T> left, right;
    boolean visit;
    
    public BTNode(){
        this(null, null, null);
    }
    public BTNode(T el){
        this(el, null, null);
    }
    public BTNode(T el, BTNode<T> l, BTNode<T> r){
        key = el;
        left = l;
        right = r;
    }
    public String toString(){
        String out = "";
        if(key == null) return  out;
        out += "K=" + key;
        if (left != null) out += " L=[" + left.toString() +"]";
        if (right != null) out += " R=[" + right.toString() + "]";
        return out ;
    }
    
    public void visit(){
        visit = true;
    } 
}
