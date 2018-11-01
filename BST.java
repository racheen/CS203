/*Tumulak, Rachel Monique K.
 *CS203
 *2CSA
 *Lab Exercise 10
 */

public class BST<T> extends BT{
    void insert(T k){
        if (root == null){
            root = new BTNode(k);
            height = "0";
        }
        else{
            BTNode n = root;
            BTNode p = null;
            while (n != null){
                p = n;
                if (((String)k).compareTo((String)n.key) < 0){
                    n = n.left;
                }
                else{
                    n = n.right;
                }
            }
            int level = 0;
            if (((String)k).compareTo((String)p.key) < 0) {
                p.left = new BTNode(k);
                p.left.level = p.level+1;
                level = p.left.level;
            }
            else{
                p.right = new BTNode(k);
                p.right.level = p.level+1;
                level = p.right.level;
            }
            if (!height.equals("undefined(tree is empty)")){
                if (Integer.parseInt(height) < level)
                    height = level +"";
            }
            
        }
    }
    BTNode<T> search(T k){
        BTNode n = root;
        while(n != null){
            if (k == n.key)
                return n;
            else{
                if (((String)k).compareTo((String)n.key) < 0)
                    n = n.left;
                else
                    n = n.right;
            }      
        }
        return null;
    }
    
    BTNode findLCA(T k1, T k2){
        BTNode a = null;
        BTNode n = root;
        Queue q1= new Queue();
        Queue q2= new Queue();
        if (search(k1) != null && search(k2) != null){
            while(!(n.key).equals(k1)){
                if (((String)k1).compareTo((String)n.key) < 0){
                    q1.enqueue(n);
                    n = n.left;
                }
                else{
                    q1.enqueue(n);
                    n = n.right; 
                }
            }
            n = root;
            while(!(n.key).equals(k2)){
                if (((String)k2).compareTo((String)n.key) < 0){
                    q2.enqueue(n);
                    n = n.left;
                }
                else{
                    q2.enqueue(n);
                    n = n.right; 
                }
            }
            while (q1.peek() == q2.peek() && !q1.isEmpty()){
                a = (BTNode)q1.dequeue();
                q2.dequeue();
            }
        }
        return a;
    }
    
    int countMoreInorder(BTNode n, T k){
        int count = 0;
        Stack<BTNode> stk = new Stack();
        if (k.equals(n.key)){
            return 0;
        }
        while (n != null){
            while (n!=null){
                if (n.right != null){
                    stk.push(n.right);
                }
                stk.push(n);
                
                n = n.left;
            }
            n = stk.pop();
            while (!stk.isEmpty() && (n.right == null)){
                n.visit();
                n = stk.pop();
                if(((String)n.key).compareTo((String)k) > 0)
                    count++;
            }
            n.visit();
            if(((String)n.key).compareTo((String)k) > 0)
                    count++;
            if(!stk.isEmpty()){
                n = stk.pop();
            }
            else n = null;
        }
        return count;
    }
}
