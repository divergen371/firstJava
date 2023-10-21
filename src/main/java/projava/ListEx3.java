package projava;

import java.util.List;

public class ListEx3 {
    public static void main(String[] args) {
        var data = List.of("grape", "banana", "apple");

        var result = 0;
        for (String s : data) {
            if (s.length()==5){
                result++;
            }
        }
        System.out.println(result);
    }
}
