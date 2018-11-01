/*Tumulak, Rachel Monique K.
 *CS203
 *2CSA
 *Lab Exercise 9
 */

public class BTBottomUp {
    public static void main(String[] args){
        BTNode $2 = new BTNode(2);
        BTNode $4 = new BTNode(4);
        BTNode $1 = new BTNode(1, null, $2);
        BTNode $5 = new BTNode(5, $4, null);
        BTNode $3 = new BTNode(3, $1, $5);
        BT bt1 = new BT();
        bt1.setRoot($3);
        System.out.println("Number of leaves= " + bt1.computeLevels());
        System.out.println(bt1.toString() + "\n");
        
        BT bt2 = new BT();
        System.out.println("Number of leaves= " + bt2.computeLevels());
        System.out.println(bt2.toString() + "\n");
        
        BTNode $E = new BTNode("E");
        BTNode $F = new BTNode("F");
        BTNode $V = new BTNode("V", $E, $F);
        BTNode $H = new BTNode("H", $V, null);
        BTNode $C = new BTNode("C", null, $H);
        BTNode $T = new BTNode("T");
        BTNode $G = new BTNode("G", null, $T);
        BTNode $D = new BTNode("D");
        BTNode $Z = new BTNode("Z", $G, $D);
        BTNode $A = new BTNode("A",null, $Z);
        BTNode $M = new BTNode("M");
        BTNode $X = new BTNode("X", $A, $M);
        BTNode $S = new BTNode("S", $C, $X);
        BT bt3 = new BT();
        bt3.setRoot($S);
        System.out.println("Number of leaves= " + bt3.computeLevels());
        System.out.println(bt3.toString() + "\n");
        
    }
}
