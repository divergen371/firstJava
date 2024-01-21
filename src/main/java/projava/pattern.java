package projava;

import java.util.List;

public class pattern {
    public static void main(String[] args) {
        List<String> data;
        data = List.of("apple", "banana", "grape");
        var result = false;
        for (var str : data) {
            for (var fruit : data) {
                if (! fruit.contains("p")) {
                    result = true;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
