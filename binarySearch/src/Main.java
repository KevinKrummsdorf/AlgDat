import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        int[] array = {2, 3, 4, 10, 40};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte geben Sie das Ziel ein: ");
        int target = scanner.nextInt();
        scanner.close();
        int result = BinarySearch.binarySearch(array, target);
        int resultAugabe = result + 1;

        if (result == -1) {
            System.out.println("Element " + target +" ist nicht im Array vorhanden");
        } else {
            System.out.println("Element " + target + " am Index " + resultAugabe + " gefunden");
        }

    }

}