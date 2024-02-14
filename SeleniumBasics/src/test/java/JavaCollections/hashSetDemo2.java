package JavaCollections;

import java.util.HashSet;

public class hashSetDemo2 {
    public static void main(String[] args) {
        HashSet evenNumbers = new HashSet<>();
        evenNumbers.add(2);
        evenNumbers.add(4);
        evenNumbers.add(6);

        HashSet <Integer> numbers = new HashSet<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        //union
        evenNumbers.add(numbers);
        System.out.println(evenNumbers);

        //intersection
        evenNumbers.retainAll(numbers);

        //difference
        evenNumbers.remove(numbers);
    }
}
