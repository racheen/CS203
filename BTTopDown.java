/*Tumulak, Rachel Monique K.
 *CS203
 *2CSA
 *Lab Exercise 10
 */
public class BTTopDown {
    public static void main(String[] args) {
        BST bst1 = new BST();
        bst1.insert("G");
        bst1.insert("T");
        bst1.insert("D");
        bst1.insert("P");
        bst1.insert("B");
        bst1.insert("L");
        bst1.insert("E");
        bst1.insert("N");
        bst1.insert("S");
        bst1.insert("M");
        bst1.insert("H");
        System.out.println(bst1);
        
        System.out.println("\nSearch:");
        Queue q = new Queue();
        q.enqueue("A");
        q.enqueue("D");
        q.enqueue("H");
        q.enqueue("G");
        q.enqueue("P");
        q.enqueue("R");
        q.enqueue("V");
        
        while(!q.isEmpty()){
            String search = (String)q.dequeue();
            if (bst1.search(search)!=null){
                System.out.println(bst1.search(search).toString() + " level = " + bst1.search(search).level);
            }
            else{
                System.out.println(search + " not found");
            }
        }
        
        System.out.println("\nLowest Common Ancestor:");
        q.enqueue("B");
        q.enqueue("B");
        q.enqueue("S");
        q.enqueue("M");
        q.enqueue("T");
        q.enqueue("L");
        
        Queue q2 = new Queue();
        q2.enqueue("Z");
        q2.enqueue("S");
        q2.enqueue("B");
        q2.enqueue("S");
        q2.enqueue("N");
        q2.enqueue("L");
        
        
        while(!q.isEmpty()){
            String k1 = (String)q.dequeue();
            String k2 = (String)q2.dequeue();
            if (bst1.search(k1)!=null && bst1.search(k2)!=null){
                System.out.println(k1 + " and " + k2 + " " + bst1.findLCA(k1,k2) + " level = " + bst1.findLCA(k1,k2).level);
                System.out.println("Number of keys more than LCA key=" + bst1.countMoreInorder(bst1.root, bst1.findLCA(k1,k2).key)+"\n");
            }
            else{
                System.out.println(k1 + " and " + k2  + " no common ancestor"+"\n");
            }
        }
        
        
    }
}
