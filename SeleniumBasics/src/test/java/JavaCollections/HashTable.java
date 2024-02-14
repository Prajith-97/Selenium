package JavaCollections;

import java.util.Hashtable;

public class HashTable {
    public static void main(String[] args) {
        Hashtable<Integer, String> hTable = new Hashtable<>();
        hTable.put(1, "john");
        hTable.put(2, "tom");
        hTable.put(3, "smith");
        System.out.println(hTable.get(1));
        System.out.println(hTable.remove(2,"tom"));
        System.out.println(hTable);
    }
}
