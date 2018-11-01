/*Tumulak, Rachel Monique K.
 *CS203
 *2CSA
 *Lab Exercise 9
 */

public class BT<T> {
    BTNode<T> root;
    String height;
    int leaves = 0;
    
    public BT(){
        root = null;
        height = "undefined(tree is empty)";
    }
    
    public void setRoot(BTNode n){
        root = n;
    }
    
    public int computeLevels(){
        Queue q = new Queue();
        BTNode<T> p = root;
        if (p != null){
            q.enqueue(p);
            p.level = 0;
            while (!q.isEmpty()){
                p = (BTNode)q.dequeue();
                System.out.println("K=" + p.key + " level="+ p.level);
                if(p.left != null) {
                    q.enqueue(p.left);
                    p.left.level = p.level + 1;
                }
                if(p.right != null){
                    q.enqueue(p.right);
                    p.right.level = p.level + 1;
                }
                if(p.left == null && p.right == null){
                    leaves++;
                }
            }
            height = p.level+"";
        }
        return leaves;
    }
    
    public String toString(){
        String out = "ht= "+ height;
        if(root != null) out += " [" + root.toString() +"]";
        return out;
    }
}
