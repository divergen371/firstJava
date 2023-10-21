package projava;

import java.util.ArrayList;
import java.util.List;

public class ListEx {
    public static void main(String[] args) {
        var data = List.of("apple", "banana", "grape");
        var result = new ArrayList<String>();
        for (String s : data) {
            if (s.length() == 5) {
                System.out.println(s);
            }
        }
    }
}
