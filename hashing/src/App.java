public class App {
    public static void main(String[] args) throws Exception {

        ClosedHashtable<Integer, String> ht = new ClosedHashtable<Integer, String>(11);
        ht.add(1, "one");
        ht.add(2, "two");
        ht.add(3, "three");
        ht.add(4, "four");
        ht.add(5, "five");
        ht.add(6, "six");
        ht.add(7, "seven");
        ht.add(8, "eight");
        ht.add(12, "twelve");
        ht.add(15, "fifteen");
        ht.printTable();
        ht.add(16, "sixteen");
        ht.printTable();
        System.out.println(ht.find(9));
        System.out.println(ht.find(3));
        ht.remove(3);
        ht.remove(6);
        ht.remove(8);
        ht.printTable();    
    
        System.out.println("\noffenes Hashing mit sondieren");
        LinearHashtable<Integer, String> linearTable = new LinearHashtable<>(10);
        linearTable.add(10, "10");
        linearTable.add(20, "20");
        linearTable.add(30, "30");
        linearTable.add(100, "100");
        linearTable.add(200, "200");
        linearTable.add(300, "300");
        linearTable.printTable();

        System.out.println("\nverkettetes Hashing");
        myHashtableChaining<Integer, String> myTable = new myHashtableChaining<>(10);
        System.out.print("Keys 100,2,3 werden hinzugefügt");
        myTable.add(100, "100");
        myTable.add(2, "200");
        myTable.add(3, "300");
        myTable.printTable();
        System.out.print("\nKey 10 wird eingefügt");
        myTable.add(10, "10");
        myTable.printTable();
        System.out.print("\nKey 10 wird entfernt");
        myTable.remove(10);
        myTable.printTable();
    }
}
