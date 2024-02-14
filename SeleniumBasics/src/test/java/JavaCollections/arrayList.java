package JavaCollections;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class arrayList {

    public static void main (String[] args) {

        List  al = new ArrayList();
//        ArrayList al = new ArrayList(); //store heterogeneous data
//    ArrayList <String> al = new ArrayList<String>();// store string variable
//    ArrayList <Integer> al = new ArrayList<Integer>();// store integer variable
//    List al = new ArrayList(); //also use list instead of ArrayList because list is the parent interface of the array list

// add new elements to the array list
        al.add(10);
        al.add(1, 2);
        al.add("welcome");
        System.out.println(al);
        al.add(1, "java");
        System.out.println(al);
        System.out.println(al.get(1)); //to get the value
        System.out.println(al.size()); // to print size of array
        //change and replace existing element
        al.set(2, "c#");
        al.contains("java"); //to check element present or not
        System.out.println(al);
//READ DATA

        //for loop
//        for (int i=0;i<al.size();i++){
//            System.out.println(al.get(i));
//        }

        //for each loop
//        for (Object ele: al){
//           System.out.println(ele);
//        }

        // Iterator
        Iterator it = al.iterator(); //iterator is an interface available in java.util package, this will add all the elements to the variable "it"
//      //using while extract all the elements
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}