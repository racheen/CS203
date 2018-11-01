/*Tumulak, Rachel Monique K.
 *CS203
 *2CSA
 *Lab Exercise 7 
 */

import java.util.Scanner;

public class QueueGame {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("t=");
        int t = Integer.parseInt(scan.nextLine());
        System.out.print("s=");
        int s = Integer.parseInt(scan.nextLine());
        System.out.print("n=");
        int n = Integer.parseInt(scan.nextLine());
        Queue<String> q = new Queue(100);
        Queue<String> q2 = new Queue(100);
        System.out.print("\nChildren: ");
        for(int i=0; i<n; i++){
            q.enqueue(giveName(i));
            System.out.print(giveName(i));
        }
        if (t==1){
            System.out.print("\nElimination Order: ");
            while (q.isEmpty()==false){
                int r = s % n;
                if (r==0) r = n;
                for(int i=1; i<r; i++)
                    q2.enqueue(q.dequeue());
                System.out.print(q.dequeue());
                while(q2.isEmpty()==false)
                    q.enqueue(q2.dequeue());
                n--;
            }
            System.out.print("\n");
        }
        if (t==2){
        }
        if (t==3){
            int count = 1;
            Stack<String> str = new Stack<>();
            while (q.isEmpty()==false){
                System.out.print("\nAfter round " + count + ": ");
                int r = s % n;
                if (r==0) r = n;
                for(int i=1; i<r; i++)
                    q2.enqueue(q.dequeue());
                str.push(q.dequeue());
                while(q2.isEmpty()==false)
                    q.enqueue(q2.dequeue());
                n--;
                for(int i=1; i<=n; i++){
                    String s2 = q.dequeue();
                    System.out.print(s2);
                    q.enqueue(s2);
                }
                count++;
            }
            System.out.print("Empty\nRanking: ");
            while (str.isEmpty()==false){
                System.out.print(str.pop());
            }
            System.out.print("\n");
        }
    }
    
    static String giveName(int num){
        String name = "";
        switch (num){
            case 0: name = "A"; break;
            case 1: name = "B"; break;
            case 2: name = "C"; break;
            case 3: name = "D"; break;
            case 4: name = "E"; break;
            case 5: name = "F"; break;
            case 6: name = "G"; break;
            case 7: name = "H"; break;
            case 8: name = "I"; break;
            case 9: name = "J"; break;
            case 10: name = "K"; break;
            case 11: name = "L"; break;
            case 12: name = "M"; break;
            case 13: name = "N"; break;
            case 14: name = "O"; break;
            case 15: name = "P"; break;
            case 16: name = "Q"; break;
            case 17: name = "R"; break;
            case 18: name = "S"; break;
            case 19: name = "T"; break;
            case 20: name = "U"; break;
            case 21: name = "V"; break;
            case 22: name = "W"; break;
            case 23: name = "X"; break;
            case 24: name = "Y"; break;
            case 25: name = "Z"; break;
        }
        return name;
    }
}
