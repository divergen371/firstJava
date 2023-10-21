package projava;

import java.util.List;

public class ListEx5 {
    public static void main(String[] args) {
        var data = List.of("apple", "banana", "grape");
        var reslut = false;

        for (String s : data) {
            if (!s.contains("p")) {
                reslut |= true;
            }
        }
        System.out.println(reslut);
    }
}
