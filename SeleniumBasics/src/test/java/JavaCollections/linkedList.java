package JavaCollections;

import java.util.LinkedList;

public class linkedList {

    public static void main(String[] args){
        LinkedList l = new LinkedList();//declare linked list; to store heterogeneous data

        LinkedList<Integer> li  = new LinkedList <Integer>(); // for integer
        LinkedList <String> lString = new LinkedList<String>();
        l.add(100);
        l.add("welcome");
        l.add(true);
        l.add('a');

        System.out.println(l.size());
        //add element in between
        l.add(1, "java");
        //retrieve data from linked list
        l.get(3);
        //set method is to replace the existing element
        l.set(4, "python");
        //contains
        System.out.println(l.contains("java"));
        System.out.println(l);

        for (int i = 0;i<l.size();i++){
            System.out.println(l.get(i));
        }

        for(Object lin:l){
            System.out.println(lin);
        }
    }



}
