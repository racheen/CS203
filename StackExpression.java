/*Tumulak, Rachel Monique K
 *CS203
 *2CSA
 *Lab Exercise 5 and 6
 */

import java.util.*;

public class StackExpression {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("t=");
        int t = Integer.parseInt(scan.nextLine());
        System.out.print("s=");
        String s = scan.nextLine();
        if (t==1){
            System.out.println("Prefix:" + s);
            System.out.println("Infix:" + prefixToInfix(s));
        }
        if (t==3){
            System.out.println("Prefix:" + s);
            System.out.println("Infix:" + prefixToInfix(s));
            System.out.println("Value:" + evalPrefix(s));
        }
        if (t==4){
            System.out.println("Infix:" + s);
            System.out.println("Prefix:" + infixToPrefix(s));
            System.out.println("Value:" + evalPrefix(infixToPrefix(s)));
        }
        if (t==6){
            System.out.println("Infix:" + s);
            System.out.println("Prefix:" + infixToPrefix(s));
            System.out.println("Value:" + evalPrefix(infixToPrefix(s)));
        }
    }
    
    static String prefixToInfix(String e){
        String[] s = e.split(" ");
        Stack<String> s2 = new Stack<>();
        for(int i= s.length - 1; i>=0; i--){
            if (isOperand(s[i])) s2.push(s[i]);
            else{
                String A = s2.pop();
                String B = s2.pop();
                s2.push("(" + A + s[i] + B + ")");
            }
        }
        return s2.pop() + "";
    }
     
    static double evalPrefix(String e){
        String[] s = e.split(" ");
        Stack<String> s2 = new Stack<>();
        double s3 = 0;
        for(int i= s.length - 1; i>=0; i--){
            if (isOperand(s[i])) s2.push(s[i]);
            else{
                double A = Double.parseDouble(s2.pop());
                double B = Double.parseDouble(s2.pop());
                s2.push(evaluate(A,s[i],B)+"");
                s3 = Double.parseDouble(s2.peek());
            }
        }
        return s3;
    }
    
    static boolean isOperand(String o){
        switch (o){
            case "*": case "/": case "+": case "-": case "^":  case "(": case ")": case "%": return false;
            default: return true;
        }
    }
    
    static double evaluate(double Operand1, String Operator, double Operand2){
        double eval=0;
        switch(Operator){
            case "*": eval = Operand1 * Operand2; break; 
            case "/": eval = Operand1 / Operand2; break;
            case "+": eval = Operand1 + Operand2; break;
            case "-": eval = Operand1 - Operand2; break;
            case "^": eval = Math.pow(Operand1, Operand2); break;
            case "%": eval = Operand1 % Operand2; break;
        }
        return eval;
    }
    
    static String infixToPrefix(String e){
        Stack<String> optr = new Stack<>();
        Stack<String> rev = new Stack<>();
        String[] s = e.split(" ");
        for (int i=s.length-1; i >= 0; i--){
            if (isOperand(s[i])) rev.push(s[i]);
            else {
                while(optr.isEmpty()==false && isLowerPrecedence(s[i],optr.peek())){ 
                    rev.push(optr.pop()); //puts operators to rev
                }
                optr.push(s[i]); //puts operators to optr
            }
        }
        while (optr.isEmpty()==false)
            rev.push(optr.pop());
        String s1 = "";
        while (rev.isEmpty() == false){
            while(rev.peek().equals("(") || rev.peek().equals(")")){
                rev.pop();
            }
            s1 = s1 + " " + rev.pop();
        }
        return s1;
    }
    
    static boolean isLowerPrecedence(String incoming, String instack){
        int priority1=0, priority2 = 0;
        switch (instack){
            case "*":  
            case "/": priority1 = 3; break;
            case "%": priority2 = 3+2; break;
            case "^": priority1 = 6+2; break;
            case "+":
            case "-": priority1 = 1; break; 
            case "(": priority1 = 9; break;
            case ")": return false;
        }
        switch (incoming){
            case "*":  
            case "/": priority2 = 4; break;
            case "%": priority2 = 4+2; break;
            case "^": priority2 = 5+2; break; 
            case "+":
            case "-": priority2 = 2; break;
            case "(": priority2 = 0; break;
            case ")": return false;
        }
        if (priority1 > priority2) return true;
        else return false;
    }
}
