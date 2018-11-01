//Tumulak, Rachel
//CS203
//2CSA
//Lab Exercise 2

import java.util.Scanner;
public class Recursion {
    
    public static String[] ss;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello User, Do you want to continue? 1 - 4");
        System.out.print("t=");
        String a = sc.nextLine();
        int t = Integer.parseInt(a);
        
        System.out.print("s=");
        String s = sc.nextLine();
        
        ss = s.split(" ");
        for(int i = 0; i < ss.length; i++){
            System.out.println(ss[i]);
        }
        
        if (t==1){
                System.out.println("The reversal is ");
                reverse(0,ss.length-1);
                for(int i = 0; i < ss.length; i++){
                    System.out.println(ss[i]);
                }
        }
        if (t==4){
                System.out.println("Number of strings alpabetically before the first is " + countBeforeFirst(0,ss.length-1));
        }
        
    }
    
    public static void reverse(int l, int r){
        String x;
        if (l<r){    
            x = ss[l];
            ss[l] = ss[r];
            ss[r] = x;
            reverse(l+1,r-1);
        } 
    }
    
    public static int countBeforeFirst(int l, int r){
        int count = 0;
        if(l<r){
            if(ss[l].compareTo(ss[r])>0){
                count= countBeforeFirst(l,r-1)   +   1;
            }else
                count = countBeforeFirst(l,r-1);
        }
        return count;
    }
    
}
