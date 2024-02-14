package JavaCollections;

import javax.sound.midi.SysexMessage;
import java.util.HashMap;
import java.util.Map;

public class Hashmap {

    public static void main(String[] args) {
        HashMap<Integer, String> m = new HashMap<Integer, String>();
//        HashMap m = new HashMap();
        System.out.println(m.isEmpty());
        m.put(9, "WHS");
        m.put(2,"UA");
        m.put(3,"VF");
       System.out.println(m.get(9));
        System.out.println(m.get(1));
        System.out.println(m.keySet());
        System.out.println(m.size());
        System.out.println(m.entrySet());
        System.out.println(m.containsValue("whs"));
        System.out.println(m.values());
        //to get the key individually
        for(Object e :m.keySet()){
            int n = Integer.parseInt(e.toString());
            System.out.println(n);
        }
        //to get the values individually
        for(Object e :m.values()){
            System.out.println(e);
        }
        //to get the key value pair
        for(Object i:m.keySet()){
            System.out.println(i+":"+m.get(i));
        }
        //Entry Methods
        for(Map.Entry entry:m.entrySet()){
            System.out.println(entry.getKey() +"-"+entry.getValue());
        }
    }
}
