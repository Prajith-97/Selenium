package JavaCollections;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Queue {

    public static void main(String[] args) {
        PriorityQueue q = new PriorityQueue();
        q.add(100);
        q.add(200);
        q.add(300);
        System.out.println(q);

        //get head element
        System.out.println(q.element());
        System.out.println(q.peek());

        //return and remove element from the queue
        System.out.println(q.remove());
        System.out.println(q);

//        System.out.println(q.poll());
//        System.out.println(q);

        Iterator it = q.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}
