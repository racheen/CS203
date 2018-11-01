/*Tumulak, Rachel
 *CS203
 *2CSA
 *Lab Exercise 8 
 */

import java.util.Scanner;

public class SLLTest {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("t=");
        int t = Integer.parseInt(scan.nextLine());
        System.out.print("s1 =");
        String s1 = scan.nextLine();
        System.out.print("s2 =");
        String s2 = scan.nextLine();
        String[] a1 = s1.split(" ");
        String[] a2 = s2.split(" ");
        SLL<Integer> slist1 = new SLL<Integer>();
        SLL<Integer> slist2 = new SLL<Integer>();
            
        if (t==1){
            System.out.println("First Linked List");
            for (int i=0; i<a1.length; i++){
                String w = a1[i];
                slist1.insertAsc(Integer.valueOf(w));
                System.out.println(slist1.toString());
            }
            System.out.println("Second Linked List");
            for (int i=0; i<a2.length; i++){
                String w = a2[i];
                slist2.insertAsc(Integer.valueOf(w));
                System.out.println(slist2.toString());
            }
        }
        if (t==2){
        }
        if (t==3){
            System.out.println("First Linked List");
            for (int i=0; i<a1.length; i++){
                String w = a1[i];
                slist1.insertAsc(Integer.valueOf(w));
                System.out.println(slist1.toString());
            }
            System.out.println("Second Linked List");
            for (int i=0; i<a2.length; i++){
                String w = a2[i];
                slist2.insertAsc(Integer.valueOf(w));
                System.out.println(slist2.toString());
            }
            SLL<Integer> slist3 = new SLL<Integer>();
            slist3 = slist1.mergeWithoutDups(slist2);
            System.out.println("Third Linked List");
            System.out.println(slist3.toString());
        }
        if (t==4){
        }
    }
    
}
