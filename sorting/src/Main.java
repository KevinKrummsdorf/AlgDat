import MergeSort.*;
import QuickSort.*;

public class Main {
    public static void main(String[] args) throws Exception {

        int[] a = {38,27,43,100,2578,3,9,82,10,1};
        int[] b = {38,27,43,100,2578,3,9,82,10,1};

        System.out.print("unsotiert:\t"+ " ");
        for (int element : a) {
         System.out.print(element + " ");
         }
        System.out.println("\n");

        //Merge Sort
        System.out.print("Merge Sort\t");
        MergeSort.mergeSort(a);
        System.out.print("sotiert:"+ " ");
        for (int element : a) {
            System.out.print(element + " ");
        }

        //Quick Sort
        System.out.print("\nQuick Sort\t");
        QuickSort.quickSort(b, 0, a.length - 1);
        System.out.print("sotiert:"+ " ");
        for (int element : a) {
            System.out.print(element + " ");
        }
    


    }
}