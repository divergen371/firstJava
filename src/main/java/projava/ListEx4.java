package projava;

import java.util.List;

public class ListEx4 {
    public static void main(String[] args) {
        var data = List.of("apple", "banana", "grape");
        var result = true;
        for (String s : data) {
            if (!s.contains("p")) {
                result = false;
            }
        }
        System.out.println(result);
    }
}
