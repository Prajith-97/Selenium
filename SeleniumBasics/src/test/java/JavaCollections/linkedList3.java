package JavaCollections;

import java.util.LinkedList;

public class linkedList3 {
    public static void main(String[] args){
        LinkedList l = new LinkedList();
        l.add("lion");
        l.add("3");
        l.add("jacket");

        //linked list specific methods
        l.addFirst("tiger");
        l.addLast("elephant");

        System.out.println(l);

        System.out.println(l.getFirst());
        System.out.println(l.getLast());

        //remove first and last element
        l.removeFirst();
        l.removeLast();
        System.out.println(l);
    }
}
