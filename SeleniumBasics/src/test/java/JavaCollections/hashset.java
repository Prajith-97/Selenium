package JavaCollections;

import java.util.HashSet;
import java.util.Iterator;

public class hashset {
    public static void main(String[] args) {
        HashSet hs = new HashSet();
        hs.add(1);
        hs.add("welcome");
        hs.add("animal");
        hs.add(true);
        hs.add(2);
        System.out.println(hs.isEmpty());
//        System.out.println(hs);
        hs.remove(1);
        System.out.println(hs.contains(1));

//        for(Object li:hs){
//            System.out.println(li);
//        }

        Iterator it = hs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        for(Object o:hs){
            System.out.println(o);
        }

    }
}