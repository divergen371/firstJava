package projava;

import java.util.Iterator;
import java.util.List;

public class ForEachListSample {
    public static void main(String[] args) {
        var strs = List.of("apple", "banana", "grape");
        Iterator<String> iterator = strs.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(str);
        }
    }
}
