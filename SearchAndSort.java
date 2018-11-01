/*Tumulak, Rachel
 *CS203
 *2CSA
 *Lab Exercise 4 
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class SearchAndSort {
    static String s1[] = new String[300];
    static String s2[] = new String[300];
    static int linearSearchCounter = 0, mergeSortCounter=0, binarySearchCounter = 0,  insertionSortCounter=0;
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Max Numbers = ");
        int maxNum = Integer.parseInt(scan.nextLine());
        System.out.println();
        BufferedReader in = new BufferedReader(new FileReader("ioc.txt"));
        for (int i=0; i<maxNum; i++){
            String s = in.readLine();
            s1[i] = s;
            s2[i] = s1[i];
            System.out.println(i+1 + " " + s1[i]);
        }
        in.close();
        System.out.println("Search Key = ");
        String searchKey = scan.nextLine();
        System.out.println("Start Index = ");
        int startIndex = Integer.parseInt(scan.nextLine())-1;
        System.out.println("End Index = ");
        int endIndex = Integer.parseInt(scan.nextLine())-1;
        System.out.println("Search key can be found in index(using linear search)" + linearSearch(startIndex, endIndex, searchKey));
        System.out.println("linear search counter = "  + linearSearchCounter);
       
        mergeSort(startIndex, endIndex, s1);
        for (int l=0; l<=(endIndex-startIndex); l++){
            System.out.println(l+1 + " " + s1[l]);
        }
        System.out.println("merge search counter = "  + mergeSortCounter);
        
        //Twist
        System.out.println("Search Key = ");
        searchKey = scan.nextLine();
        System.out.println("Start Index = ");
        startIndex = Integer.parseInt(scan.nextLine())-1;
        System.out.println("End Index = ");
        endIndex = Integer.parseInt(scan.nextLine())-1;
        System.out.println("Search key can be found in index(using binary search)" + binarySearch(startIndex, endIndex, searchKey));
        System.out.println("binary search counter = "  + binarySearchCounter);
        
        insertionSort(s1, startIndex, endIndex);
        for (int l=0; l<=(endIndex-startIndex); l++){
            System.out.println(l+1 + " " + s1[l]);
        }
        System.out.println("insertion search counter = "  + insertionSortCounter);
    }
    
    public static int linearSearch(int start, int end, String search){
        int searchedIndex=0;
        int i=start;
        while(i<=end){
            if(search.equals(s1[i])) {searchedIndex = i+1; break;}
            else searchedIndex = -999;
            i++;
            linearSearchCounter++;
        }
        
        /*
        b. An iterative linear search method that searches a subarray from start to end indices and
        returns an index where a given search key is located in the subarray.
            i. Increment the linear search counter variable each time a comparison is made
            against an array element. 
        */
        return searchedIndex;
    }
    
    public static void mergeSort(int start, int end, String[] s1){
        if(start<end){
            int q = (int) Math.floor((start+end)/2); 
            mergeSort(start,q,s1);
            mergeSort(q+1,end,s1);
            merge(s1, start, q, end);
        }
        /*
        c. merge sort and merge methods that sort an input (sub)array in descending order.
            i. The merge sort method accepts as parameters a String array name, the start
            index, and the end index of a subarray that it needs to sort.
          
            iii. Increment the merge sort counter variable each time a comparison is made
            against an array element. 
        */
    }
    
    public static void merge(String[] A, int start, int q, int end){
    String temp[] = new String[100];
    for (int r = 0; r <= end; r++) {
        temp[r] = A[r];
    }
    int i = start;
    int j = q + 1;
    int k = start;
    
    while (i <= q && j <= end) {
        if (temp[i].compareTo(temp[j])<=0) {
            A[k] = temp[j];
            ++j;
        } else {
            A[k] = temp[i];
            ++i;
        }
        mergeSortCounter++;
        k++;
    }
    
    while (i <= q) {
        A[k] = temp[i];
        k++;
        i++;
        mergeSortCounter++;
    }

        /*ii. The merge method accepts a String array name and the start, middle, and end
            indices of a subarray. The sorted subarray from start to middle must be merged
            with the sorted subarray after middle to end to form a sorted array from start to
            end.
        */
    }
    
    public static  int binarySearch(int start, int end, String search){
        if (start>end) return -999;
        int m = (int) Math.floor((start+end)/2);
        if (search.equals(s1[m])) {binarySearchCounter++; return m+1;}
        else if (search.compareTo(s1[m])>0) {binarySearchCounter++; return binarySearch(start, end-1, search);}
        else {binarySearchCounter++; return binarySearch(start+1, end, search);}
        /*
        A recursive binary search method that searches a sorted subarray in descending order
        from start to end indices and returns an index where a given search key is located in the
        subarray.
            i. Increment the binary search counter variable each time a comparison is made
            against an array element. 
        */
    }
    
    public static void insertionSort(String[] A, int start, int end){
        for(int j=1; j<=end; j++){
            String s = A[j];
            int i = j-1;
            while(i>=0 && A[i].compareTo(s)>=0){
                A[i+1] = A[i];
                i--;
                insertionSortCounter++;
            }
            A[i+1] = s;
        }
        /*
        an insertion sort method that sorts an input (sub)array in ascending order.
            i. This method accepts as parameters a String array name, the start index, and the
            end index of a subarray that it needs to sort.
            ii. Increment the insertion sort counter variable each time a comparison is made
            against an array element.
        */
        
    }
    
    /*
    a.Compare the merge sort counter versus the insertion sort counter. Which one is better
      for the same input size? Why? Is this the case for any input size or for most input sizes?
      
    Merge sort is better since it has a fewer counter compared to insertion sort counter. This is the case for most input sizes.
    
    b. Compare the linear search counter versus the binary search counter. Which one is often
        better for the same input size? Why? Why is it not always better for the same input
        size?
    
    Linear sort is better since it has a fewer counter compared to binary sort counter but not in all cases because linear search may have a fewer counter
    but not always better.
    */
}

