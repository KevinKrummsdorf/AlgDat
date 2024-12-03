package MergeSort;
public class MergeSort {

    public static void mergeSort(int[] a) {
        int[] helpa = new int[a.length];
        doMergeSort(a,0, a.length - 1 , helpa);  
        }
    

    public static void doMergeSort(int[] a, int left, int right, int[] helpa) {
        if (right - left > 0) {
            int middle = (left + right) / 2;
            doMergeSort(a, left, middle,helpa);
            doMergeSort(a, middle+1, right, helpa);
            //System.out.print("Zu sortierende Teile: ");
            //printArrayPart(a, left, right);
            mergeParts(a, helpa, left, middle, right);
            //System.out.print("Aktueller Zustand nach mergeParts:"+ " ");
            //printArray(a);
        }
    }

    public static void mergeParts(int[] a, int[] helpA, int leftEnd, int middle, int rightEnd) {
        for(int i = leftEnd; i <= rightEnd; i++){
           helpA[i] = a[i];
       }

        int leftIndex = leftEnd;
        int rightIndex = middle + 1;
        int outIndex = leftEnd;

        while (leftIndex <= middle && rightIndex <= rightEnd){
            if (helpA[leftIndex] < helpA[rightIndex]){
                a[outIndex] = helpA[leftIndex];
                leftIndex++;
            } else {
                a[outIndex] = helpA[rightIndex];
                rightIndex++;
            }
            outIndex++;
        }

        while (leftIndex <= middle){
            a[outIndex] = helpA[leftIndex];
            outIndex++;
            leftIndex++;
        }
        
        while (rightIndex <= rightEnd) {
            a[outIndex] = helpA[outIndex];
            outIndex++;
            rightIndex++;
        }
    }

    public static void printArray(int[] a) {
        for (int element : a) {
            System.out.print(+element + " ");
        }
        System.out.println();
    }

    public static void printArrayPart(int[] a, int left, int right) {
        for (int i = left; i <= right; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}