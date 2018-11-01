/* Tumulak, Rachel Monique K
 * CS203
 * 2CSA
 * Lab Exercise 0
 */

import java.util.*;

public class Practice {
    public static void main(String[] args) {
        System.out.print("Hello World \n Please input a number: ");
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        System.out.println("\n The factorial of that number is: " + getFactorial(i));
        System.out.println("\n The fibonacci of that number is: " + getFibonacci(i));
    }
    
    static int getFactorial(int num){
        int factorial;
        if (num == 0)
            factorial = 1;
        else
            factorial = num*getFactorial(num-1);
                
        return factorial;
    }
    
    static int getFibonacci(int num){
        int fib;
        if (num == 1 || num == 0)
            fib = num;
        else
            fib = getFibonacci(num-1)+getFibonacci(num-2);
        
        return fib;
    }
}
