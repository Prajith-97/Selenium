package JavaCollections;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class linkedList2 {
  public static void main(String[] args){
      LinkedList li = new LinkedList();
      li.add('a');
      li.add('m');
      li.add('o');
      li.add('e');
      LinkedList newLi = new LinkedList();
      newLi.addAll(li);//for adding all elements

      Collections.sort(li);
      System.out.println(li);

      Collections.sort(li, Collections.reverseOrder());
      System.out.println(li); // for reversing

      Collections.shuffle(li);
      System.out.println(li);
  }


}
