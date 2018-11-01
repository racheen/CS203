
/*Tumulak, Rachel
 *CS203
 *2CSA
 *Lab Exercise 3 
 */

import java.util.*;

public class BigOh {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int maxTime=0;
        double n;
        double startTime;
        double elapseTime;
        
        do{ 
            System.out.print("Max Time = ");
            maxTime = scan.nextInt();
          }
        while(maxTime<0);
        
        n=1;
        startTime = System.nanoTime()*(Math.pow(10,-9));
        System.out.println("Ordered Pairs");
        do{
            System.out.println("n=" + n);
            getOP(n);
            double currentTime = System.nanoTime()*(Math.pow(10,-9));
            elapseTime = currentTime-startTime;
            n++;
        }while(elapseTime < maxTime);
        double OP=n;
                
        n=1;
        startTime = System.nanoTime()*(Math.pow(10,-9));
        System.out.println("Power by Halving");
        do{
            System.out.println("n=" + n);
            getPH(n);
            double currentTime = System.nanoTime()*(Math.pow(10,-9));
            elapseTime = currentTime-startTime;
            n++;
        }while(elapseTime < maxTime);
        double PH=n;
        
        n=1;
        startTime = System.nanoTime()*(Math.pow(10,-9));
        System.out.println("Power by Reduction");
        do{
            System.out.println("n=" + n);
            getPR(n);
            double currentTime = System.nanoTime()*(Math.pow(10,-9));
            elapseTime = currentTime-startTime;
            n++;
        }while(elapseTime < maxTime);
        double PR=n;
        
        System.out.println("OP="+OP +" PH="+ PH +" PR="+ PR);
    }
    
    public static void getOP(double n){
        for(int i=1;i<=n;i++){
           for(int j=1;j<=n;j++){
           System.out.print("(" + i + "," + j + ")");
           }
        }
        System.out.println();
    }
    
    public static double getPH(double n){
        double b=1.0001;
        if (n==0) return 1;
        else if (n%2 != 0 && n>0) return b* Math.pow(getPH((n-1)/2),2);      
        else return Math.pow(getPH(n/2),2);
    }
    
    public static double getPR(double n){
        double b=1.0001;
        double a=0;
        if (n==0) a= 1;
        else if (n>=1) a=b*getPR(n-1);  
        return a;
    }
}
