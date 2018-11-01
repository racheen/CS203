/* Tumulak, Rachel Monique K
 * CS203 
 * 2CSA
 * Lab Exercise 1
 */
import java.util.*;
public class Matrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int M[][] = new int[][]
                      {{2,1,1,1,1,1,1,1,1,2},
                      {1,0,0,0,0,0,0,0,0,1},
                      {1,0,-1,-1,-1,-1,-1,-1,0,1},
                      {1,0,2,2,0,0,1,1,0,1},
                      {1,0,2,2,0,0,1,1,0,1},
                      {1,0,3,3,4,5,-2,-2,0,1},
                      {1,0,3,3,6,7,-2,-2,0,1},
                      {1,0,-1,-1,-1,-1,-1,-1,0,1},
                      {1,0,0,0,0,0,0,0,0,1},
                      {2,1,1,1,1,1,1,1,1,2}};
        
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                System.out.format("%3d", M[i][j]);
            }
            System.out.print("\n");
        }
        
        System.out.print("t=");
        int t = scan.nextInt();
        
        while(t!=0){
            while(t==1){
                System.out.print("m="); 
                int m = scan.nextInt();
                System.out.print("n=");
                int n = scan.nextInt();
                System.out.print("p=");
                int p = scan.nextInt();
                System.out.print("r=");
                int r = scan.nextInt();
                System.out.print("s=");
                int s = scan.nextInt();
                System.out.print("v=");
                int u = scan.nextInt();
                System.out.print("v=");
                int v = scan.nextInt();
           
                multiplySubmatrices(printSubmatrix(M, m, n, r, s),printSubmatrix(M, n, p, u, v), m, p, n);
                System.out.print("\n");
                System.out.print("t=");
                t = scan.nextInt();
            }
        
            while(t==2){
                System.out.print("m="); 
                int m = scan.nextInt();
                System.out.print("n=");
                int n = scan.nextInt();
                System.out.print("r=");
                int r = scan.nextInt();
                System.out.print("s=");
                int s = scan.nextInt();
                System.out.print("v=");
                int u = scan.nextInt();
                System.out.print("v=");
                int v = scan.nextInt();
                System.out.print("c=");
                int c = scan.nextInt();
        
                scalarmSubmatrices(printSubmatrix(M, m, n, r, s),printSubmatrix(M, m, n, u, v), m, n, c);
                System.out.print("\n");
                System.out.print("t=");
                t = scan.nextInt();
            }
        }
    }
    
    static int[][] printSubmatrix(int M[][], int rows, int cols, int rowsM, int colsM){
        System.out.print("\n");
        int cc=colsM;
        int rr=rowsM;
        int A[][] = new int[rows][cols];
                
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                A[i][j]=M[rr][cc];
                System.out.format("%3d", M[rr][cc]); 
                cc++;
            }
            cc=colsM;
            System.out.print("\n");
            rr++;
        }
        return A;
    }
    
    static void multiplySubmatrices(int A[][], int B[][], int m, int p, int n){
        System.out.print("\n");
        int sum=0;
        for (int i = 0 ; i < m ; i++ ){
            for (int j = 0 ; j < p ; j++ ){   
               for (int k = 0 ; k < n ; k++ ){
                  sum = sum + A[i][k]*B[k][j];
               }
               System.out.format("%3d", sum);
               sum = 0;
            }
            System.out.print("\n");
        }
    }
    
    static void scalarmSubmatrices(int A[][], int B[][], int m, int n, int c){
        System.out.print("\n");
        int C[][] = new int[m][n];
        for(int i=0; i<m; i++){
            for (int j = 0 ; j <n ; j++ ){ 
                C[i][j] = c*(A[i][j]-B[i][j]);
                System.out.format("%3d", C[i][j]);
            }
            System.out.print("\n");
        }
    }
}
